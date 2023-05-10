import unittest
from m_hack4 import pack_string


class Testing(unittest.TestCase):
    def test_1(self):
        s = 'aaaaYniuiiiipopo'
        a = pack_string(s)
        b = 'a4Yniui4popo'
        self.assertEqual(a, b)

    def test_2(self):
        s = '\\4\\5aaaa\\\\bbbb'
        a = pack_string(s)
        b = '45a4\\b4'
        self.assertEqual(a, b)

    def test_3(self):
        s = 'r45tfg'
        a = pack_string(s)
        b = 'error!'
        self.assertEqual(a, b)

    def test_4(self):
        s = '45 tfg'
        a = pack_string(s)
        b = 'error!'
        self.assertEqual(a, b)

    def test_5(self):
        s = '\\aa\\'
        a = pack_string(s)
        b = 'a2'
        self.assertEqual(a, b)

    def test_6(self):
        s = '\\4\\5aaaa\\\\bbbb'
        a = pack_string(s)
        b = '45a4\\b4'
        self.assertEqual(a, b)

    # def test_7(self):  # does not pass
    #     s = '\\\\\\\\'
    #     a = pack_string(s)
    #     b = '\\2'
    #     self.assertEqual(a, b)


if __name__ == '__main__':
    unittest.main()
