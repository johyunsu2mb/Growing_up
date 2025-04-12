# ===== 1. f-string (문자열 포매팅) =====
# f-string은 문자열 안에 변수를 쉽게 삽입할 수 있게 해주는 기능입니다.
i = 4
print(f'123{i}')  # 출력: 1234

# ===== 2. 조건문 (if, elif, else) =====
# 조건에 따라 실행할 코드를 결정합니다:
# - if: 첫 번째 조건이 참이면 실행
# - elif: 앞선 조건이 거짓이고 현재 조건이 참이면 실행
# - else: 모든 조건이 거짓일 때 실행
a = 1
if a == 1:
    print("a=1")  # a가 1이므로 이 코드가 실행됨
elif a == 2:
    print("a=2")  # a가 2가 아니므로 실행 안 됨
else:
    print("a=?")  # 위 조건들이 모두 거짓일 때 실행됨

# ===== 3. 반복문 (range, while, for) =====

# range(): 연속된 숫자 시퀀스를 생성합니다
# - range(10): 0부터 9까지의 숫자 시퀀스
# - range(1, 11): 1부터 10까지의 숫자 시퀀스
numbers = list(range(0, 10))  # 0부터 9까지의 리스트 생성
print("range로 생성한 리스트:", numbers)

# while 반복문: 조건이 참인 동안 코드를 반복합니다. 반복 횟수가 유동적일 때 유용합니다.
print("\nwhile 반복문 실행:")
i = 0
while i < 5:  # i가 5보다 작은 동안 반복
    print(f"while 반복 {i}번째")
    i += 1  # i를 1씩 증가

# for 반복문: 정해진 시퀀스의 각 항목에 대해 반복합니다. 반복 횟수가 명확할 때 유용합니다.
print("\nfor 반복문 실행:")
for i in range(1, 6):  # 1부터 5까지 반복
    print(f"for 반복 {i}번째")

# ===== 4. 데이터 구조 =====
# 여러 데이터를 하나로 묶는 자료구조들

# 리스트(List): 순서가 있고, 변경 가능한 컬렉션
print("\n리스트(List) 예제:")
li = [1, 2, 3, 4]
print("원래 리스트:", li)
li.append(5)  # 값 추가
print("값을 추가한 후:", li)
li[0] = 10  # 값 변경
print("값을 변경한 후:", li)
li.remove(3)  # 값 삭제
print("값을 삭제한 후:", li)

# 튜플(Tuple): 순서가 있고, 변경 불가능한 컬렉션
print("\n튜플(Tuple) 예제:")
tup = (1, 2, 3, 4)
print("튜플:", tup)
# tup[0] = 10  # 튜플은 수정 불가능 (실행 시 오류 발생)

# 딕셔너리(Dictionary): 키-값 쌍의 컬렉션
print("\n딕셔너리(Dictionary) 예제:")
dic = {1: '일', 2: '이', 3: '삼'}
print("딕셔너리:", dic)
print("키 1의 값:", dic[1])  # 키를 통해 값에 접근
dic[4] = '사'  # 새 키-값 쌍 추가
print("키-값 쌍 추가 후:", dic)

# ===== 5. 함수(def) =====
# 반복되는 코드나 재사용이 필요한 코드를 묶어 놓은 것입니다.
print("\n함수(def) 예제:")

# 기본 함수 정의
def greet(name):
    return f"안녕하세요, {name}님!"

print(greet("홍길동"))

# 조건에 따른 반환값이 있는 함수
def check_multiple(num):
    if num % 5 == 0:
        return "5의 배수입니다"
    else:
        return "5의 배수가 아닙니다"

print(f"10은 {check_multiple(10)}")
print(f"7은 {check_multiple(7)}")

# 가변 인자(*args) 사용 함수
def sum_all(*args):  # 여러 인자를 받아 튜플로 저장
    total = 0
    for arg in args:
        total += arg
    return total

print(f"1+2+3+4의 합: {sum_all(1, 2, 3, 4)}")

# 전역변수(global) 사용 예제
counter = 0

def increase_counter():
    global counter  # 전역변수 counter에 접근
    counter += 1
    return counter

print(f"카운터 증가: {increase_counter()}")
print(f"카운터 증가: {increase_counter()}")
print(f"최종 카운터 값: {counter}")

# ===== 6. 모듈과 패키지, 라이브러리 =====
# 실제 사용하려면 해당 라이브러리를 설치해야 합니다.
# 모듈과 패키지와 라이브러리는 주석으로 예제만 표시
'''
# 모듈(Module): 특정 기능을 하는 파이썬 파일
print("os 모듈 불러오기 예제:")
import os
print(f"현재 작업 디렉토리: {os.getcwd()}")

# 패키지(Package): 여러 모듈을 디렉토리 형태로 구조화한 것
import numpy as np  # 수치 계산을 위한 패키지
arr = np.array([1, 2, 3, 4, 5])
print(f"NumPy 배열: {arr}")
print(f"배열의 평균: {np.mean(arr)}")

# 라이브러리(Library): 모듈과 패키지의 모음
import matplotlib.pyplot as plt  # 데이터 시각화 라이브러리
plt.plot([1, 2, 3, 4], [1, 4, 9, 16])
plt.title('예제 그래프')
plt.xlabel('x 축')
plt.ylabel('y 축')
plt.show()

import pandas as pd  # 데이터 분석 라이브러리
df = pd.DataFrame({'A': [1, 2, 3], 'B': [4, 5, 6]})
print(f"Pandas DataFrame:\n{df}")

from sklearn.datasets import load_iris  # 머신러닝 라이브러리
iris = load_iris()
print(f"Iris 데이터셋 크기: {iris.data.shape}")
'''