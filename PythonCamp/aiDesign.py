def print_hi(name):
    print(f'Hi, {name}')

def list_to_map(l):
    return {i: l[i] for i in range(len(l))}

# 人脸检测
def face_detect(img):
    # 初始化模型
    detector = dlib.get_frontal_face_detector()
    # 读取图片
    # img = cv2.imread(img_path)
    # 转换为灰度图
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # 人脸检测
    dets = detector(img_gray, 1)
    # 获取人脸框
    faces = []
    for i, d in enumerate(dets):
        x1 = d.top() if d.top() > 0 else 0
        y1 = d.bottom() if d.bottom() > 0 else 0
        x2 = d.left() if d.left() > 0 else 0
        y2 = d.right() if d.right() > 0 else 0

if __name__ == '__main__':
    print_hi('PyCharm')
