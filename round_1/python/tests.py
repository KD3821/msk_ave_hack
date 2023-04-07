import unittest
from m_hack import do_work


class Testing(unittest.TestCase):
    def test_1(self):
        s = 'a17'
        a = do_work(s)
        b = 'aaaaaaaaaaaaaaaaa'
        self.assertEqual(a, b)

    def test_2(self):
        s = 'yu7o9k3Ж9m4'
        a = do_work(s)
        b = 'yuuuuuuuoooooooookkkЖЖЖЖЖЖЖЖЖmmmm'
        self.assertEqual(a, b)

    def test_3(self):
        s = '2a b 5'
        a = do_work(s)
        b = 'a b     '
        self.assertEqual(a, b)

    def test_4(self):
        s = '7💩3 _ .6a'
        a = do_work(s)
        b = '💩💩💩 _ ......a'
        self.assertEqual(a, b)



if __name__ == '__main__':
    unittest.main()


# python3 -m unittest tests.Testing  (to run file)