with open('task4.txt', encoding='utf-8') as f:
    data = f.read()

def pack_string(data):
    res = ''
    counter = 1
    is_bslash = False
    err = 'error!'
    if len(data) == 0:
        return err

    for i in range(len(data)):
        if data[i] == '\\' and is_bslash is True:
            res += data[i]
            is_bslash = False

        elif data[i] == '\\':

            if counter != 1:
                res += str(counter)
                counter = 1
            is_bslash = True

        elif data[i].isnumeric() and is_bslash is True:
            res += data[i]
            is_bslash = False

        elif data[i].isnumeric():
            return err

        elif data[i].isalpha() and is_bslash is True:
            res += data[i]
            is_bslash = False

        elif len(res) >= 1 and i != len(data) - 1:

            if data[i] == res[-1]:
                counter += 1

            else:
                if counter != 1:
                    res += str(counter)
                    counter = 1
                res += data[i]

        elif len(res) >= 1:
            if data[i] == res[-1]:
                counter += 1
                res += str(counter)
            else:
                res += data[i]

        else:
            res += data[i]

    return res

print(pack_string(data))


