import unittest

class Solution:
    # http://oj.leetcode.com/problems/reverse-words-in-a-string/
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        words = s.split()
        words.reverse()
        return ' '.join(words)

    # http://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        stack = []
        operators = ['+','-','*','/']
        for token in tokens:
            if token not in operators:
                stack.append(int(token))
            else:
                a = stack.pop()
                b = stack.pop()

                if token == '*':
                    stack.append(a*b)
                elif token == '+':
                    stack.append(a+b)
                elif token == '-':
                    stack.append(b-a)
                elif token == '/':
                    stack.append(int(float(b)/a))
        return stack.pop()

class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.Solution = Solution()

    def testReverseWords(self):
        s = self.Solution.reverseWords(" ab  12 ")
        self.assertEqual(s, "12 ab")

    def testEvalRPN(self):
        s = ["2", "1", "+", "3", "*"]
        self.assertEqual(self.Solution.evalRPN(s), 9)
        s = ["4", "13", "5", "/", "+"]
        self.assertEqual(self.Solution.evalRPN(s), 6)
        s = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        self.assertEqual(self.Solution.evalRPN(s), 22)