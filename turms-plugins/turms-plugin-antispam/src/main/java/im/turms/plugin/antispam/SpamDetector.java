/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.plugin.antispam;

import im.turms.plugin.antispam.ac.AhoCorasickDoubleArrayTrie;

/**
 * @author James Chen
 */
public class SpamDetector extends AhoCorasickDoubleArrayTrie {

    private final TextPreprocessor textPreprocessor;

    public SpamDetector(TextPreprocessor textPreprocessor, AhoCorasickDoubleArrayTrie trie) {
        super(trie.fail, trie.output, trie.dat);
        this.textPreprocessor = textPreprocessor;
    }

    public String mask(String str, char mask) {
        char code;
        Object newChars;
        int firstCharIndex = 0;
        int currentState = 0;
        int nextState;
        // TODO: use bytes for better performance
        char[] maskedChars = null;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            code = str.charAt(i);
            newChars = textPreprocessor.process(code);
            if (newChars instanceof char[] chars) {
                for (char c : chars) {
                    nextState = transition(currentState, c);
                    while (nextState == -1) {
                        currentState = fail[currentState];
                        if (currentState == 0) {
                            firstCharIndex = i;
                        }
                        nextState = transition(currentState, c);
                    }
                    currentState = nextState;
                    if (output[currentState] != null) {
                        if (maskedChars == null) {
                            maskedChars = str.toCharArray();
                        }
                        for (int j = firstCharIndex; j <= i; j++) {
                            maskedChars[j] = mask;
                        }
                    }
                }
            } else if (newChars instanceof Character c) {
                nextState = transition(currentState, c);
                while (nextState == -1) {
                    currentState = fail[currentState];
                    if (currentState == 0) {
                        firstCharIndex = i;
                    }
                    nextState = transition(currentState, c);
                }
                currentState = nextState;
                if (output[currentState] != null) {
                    if (maskedChars == null) {
                        maskedChars = str.toCharArray();
                    }
                    for (int j = firstCharIndex; j <= i; j++) {
                        maskedChars[j] = mask;
                    }
                }
            }
        }
        if (maskedChars == null) {
            return null;
        }
        return new String(maskedChars);
    }

    public boolean containsUnwantedWords(String text) {
        int currentState = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char code = text.charAt(i);
            Object newChars = textPreprocessor.process(code);
            if (newChars instanceof char[] chars) {
                for (char c : chars) {
                    currentState = findNextState(currentState, c);
                    if (output[currentState] != null) {
                        return true;
                    }
                }
            } else if (newChars instanceof Character c) {
                currentState = findNextState(currentState, c);
                if (output[currentState] != null) {
                    return true;
                }
            }
        }
        return false;
    }

}
