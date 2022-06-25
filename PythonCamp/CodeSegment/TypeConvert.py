# python 数据类型转化

# 列表转换为字典
def list_to_map(l):
    return {i: l[i] for i in range(len(l))}

# 列表转化为集合
def list_to_set(l):
    return {i for i in l}

# 字典转换为列表
def map_to_list(m):
    return [m[i] for i in m]

# 字典转换为集合
def map_to_set(m):
    return {m[i] for i in m}

# 集合转化为字典
def set_to_map(s):
    return {i: s[i] for i in s}

# 集合转化为列表
def set_to_list(s):
    return [i for i in s]

if __name__ == '__main__':
    l = [1, 2, 3, 4, 5]
    name = ["id", "name", "sex", "age", "score"]
    print(l)
    m = list_to_map(l)
    print(m)
    # 更换key值
    m = {name[i]: l[i] for i in range(len(l))}
    print(m)
    print('PyCharm')