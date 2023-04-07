with open('task.txt', encoding='utf-8') as f:
    data = f.read()

def do_work(data):
    res = ''
    numbers = {}
    num = ''
    key = ''
    for i in range(len(data)):
        if i == 0:
            if data[i].isnumeric():
                continue
            else:
                key = data[i]
                numbers[key] = 1
        else:
            if data[i].isnumeric():
                if data[i-1].isnumeric() and key == '':
                    continue
                else:
                    if data[i-1].isnumeric():
                        num += data[i]
                        numbers[key] = num
                    else:
                        num = data[i]
                        numbers[key] = num
            else:
                for key, value in numbers.items():
                    for j in range(int(value)):
                        res += key
                numbers = {}
                key = data[i]
                numbers[key] = 1
    for key, value in numbers.items():
        for j in range(int(value)):
            res += key
    return res

with open('result.txt', encoding='utf-8', mode='w+') as f:
    f.write(do_work(data))
