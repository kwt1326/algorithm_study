# encoding: utf-8
from typing import List

# Backtracking
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        keypad = {
            2: ['a','b','c'],
            3: ['d','e','f'],
            4: ['g','h','i'],
            5: ['j','k','l'],
            6: ['m','n','o'],
            7: ['p','q','r','s'],
            8: ['t','u','v'],
            9: ['w','x','y','z'],
        }
        ds = {}
        result = []
        for d in digits:
            ds[d] = keypad[int(d)]

        def bt(i, letter):
            if i >= len(digits):
                result.append(letter)
                return
            num = int(digits[i])
            chars = keypad[num]
            for c in chars:
                bt(i + 1, letter + c)

        if digits:
            bt(0, "")
        
        return result
    
print(Solution().letterCombinations("23"))
print(Solution().letterCombinations(""))
print(Solution().letterCombinations("2"))