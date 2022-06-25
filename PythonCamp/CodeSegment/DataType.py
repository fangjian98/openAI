# Python基本数据类型初始化 构造 遍历

def list_type():
    # list
    list1 = [1, 2, 3, 4, 5]
    # 列表添加元素 值
    list1.append(6)
    # 列表删除元素 值
    list1.remove(list1[0])
    # 列表遍历
    for i in list1:
        print(i)
    # 列表获取元素 index
    print(list1[2])


def tuple_type():
    #tuple
    tuple1 = (1, 2, 3, 4, 5)
    # 元组遍历
    for i in tuple1:
        print(i)
    # 元组添加元素
    tuple1 += (6,)
    # 元组不可删除元素，可拼接
    tuple1 += (7, 8, 9)
    # 元组获取元素
    print(tuple1)
    print(tuple1[-2])  # 查找倒数第二个元素
    print(tuple1[1:4])  # 查找第二到第五个元素
    print(tuple1[4:])  # 从第五个查找到最后一个
    print(tuple1[:4])  # 从第0个查找到第五个
    print(tuple1[1:6:2])  # 从第二个到第七个，每隔2个查询一次
    print(tuple1[::-1])  # 翻转元组
    print(tuple1[5:2:-1])  # 5到2翻转元组，取不到2的值


def set_type():
    #set
    set1 = {1, 2, 3, 4, 5}   
    # 集合添加元素
    set1.add(6)
    # 集合删除元素
    set1.remove(5)
     # 集合遍历
    for i in set1:
        print(i)
    # 集合获取第index个元素
    l = list(set1)
    print(l[2])
    


def dict_type():
    #dict
    dict1 = {'a': 1, 'b': 2, 'c': 3}
    # 字典遍历
    for i in dict1:
        print(i)
        print(dict1[i])
    # 字典添加元素
    dict1['d'] = 4
    # 字典删除元素
    del dict1['a']
    # 字典获取元素
    print(dict1['b'])
    # 字典获取元素 index
    print(dict1.get('c'))
    # 字典获取元素 index 如果不存在返回None
    print(dict1.get('d'))
    # 字典获取元素 index 如果不存在返回默认值
    print(dict1.get('e', 5))


if __name__ == '__main__':
    print('PyCharm')
    set_type()
