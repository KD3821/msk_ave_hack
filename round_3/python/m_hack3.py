with open('task3.txt', encoding='utf-8') as f:
    data = f.read()


def check(word, words):
    if word in words.keys():
        counter = words[word]
        counter += 1
        words[word] = counter
        word = ''
    else:
        words[word] = 1
        word = ''
    return word, words


def check2(words):
    new_words = {}
    for key, value in words.items():
        if key == '-':
            continue
        word_mod = key.lower()
        if word_mod[-1] in dd_list:
            word_mod = word_mod[:-2]
            if word_mod in words:
                val1 = words.get(word_mod)
                val2 = val1 + value
                new_words[word_mod] = val2
        new_words[word_mod] = value
    return new_words


d_list = ['\n', '', ' ', '-', ',', '.', '!', '?', ':', ';', '"']
dd_list = ['.', ',', '!', '?', ':', ';', '"']


def do_task(data):
    word = ''
    words = {}
    for i in data:
        if i in d_list:
            if len(word) != 0 and i in dd_list:
                word += i
                word, words = check(word, words)
            elif len(word) == 0 and i == '-':
                word = i
                word, words = check(word, words)
            elif i == '-':
                word, words = check(word, words)
                word = i
                word, words = check(word, words)
            elif i in dd_list:
                word += i
                word, words = check(word, words)
            else:
                word, words = check(word, words)
        else:
            word += i
    res = {}
    for key, value in words.items():
        if key not in d_list:
            res[key] = value
        if key == '-':
            res[key] = value
    # res = check2(res)
    v_list = []
    for key, value in res.items():
        v_list.append(value)
    v_list.sort(reverse=True)
    top = []
    for key, value in res.items():
        if value in v_list[0:10]:
            top.append(key)
            if len(top) == 10:
                break
    print(top)
    return top

do_task(data)
