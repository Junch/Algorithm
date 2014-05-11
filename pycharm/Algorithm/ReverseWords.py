import unittest

class Solution:
    # http://oj.leetcode.com/problems/reverse-words-in-a-string/
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        words = s.split()
        words.reverse()
        return ' '.join(words)

class SolutionTest(unittest.TestCase):
    def setUp(self):
        self.Solution = Solution()

    def testReverseWordsGeneral(self):
        s = self.Solution.reverseWords(" ab  12 ")
        self.assertEqual(s, "12 ab")
