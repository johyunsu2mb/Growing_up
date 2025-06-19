# ============================================================================
# Python 주요 개념 정리
# 이 코드는 Python의 기본 개념들을 C 언어 구조 스타일로 설명합니다.
# ============================================================================

# ===== 1. 변수와 자료형 =====
print("1. 변수와 자료형")

# 변수 선언 및 자료형
i = 10              # 정수형
f = 3.14            # 실수형
s = "Hello"         # 문자열
b = True            # 불리언
l = [1, 2, 3]       # 리스트
d = {"key": "val"}  # 딕셔너리

print(f"정수: {i}")
print(f"실수: {f}")
print(f"문자열: {s}")
print(f"불리언: {b}")
print(f"리스트: {l}")
print(f"딕셔너리: {d}\n")

# ===== 2. 연산자 =====
print("2. 연산자")

a, b = 5, 2
print(f"덧셈: {a + b}")
print(f"뺄셈: {a - b}")
print(f"곱셈: {a * b}")
print(f"나눗셈: {a / b}")
print(f"몫: {a // b}")
print(f"나머지: {a % b}")
print(f"거듭제곱: {a ** b}")

print(f"비교: a > b -> {a > b}")
print(f"논리: a > 1 and b < 5 -> {a > 1 and b < 5}\n")

# ===== 3. 문자열 처리 =====
print("3. 문자열 처리")

text = "Python"
print(f"문자열: {text}")
print(f"첫 글자: {text[0]}")
print(f"슬라이싱: {text[1:4]}")
print(f"길이: {len(text)}")
print(f"포맷팅: Hello, {text}!\n")

# ===== 4. 조건문 =====
print("4. 조건문")

num = -5
if num > 0:
    print("양수입니다.")
elif num < 0:
    print("음수입니다.")
else:
    print("0입니다.\n")

# ===== 5. 반복문 =====
print("5. 반복문")

# for문
print("- for문:")
for i in range(3):
    print(f"  반복 {i+1}회차")

# while문
print("\n- while문:")
count = 0
while count < 3:
    print(f"  반복 {count+1}회차")
    count += 1
print()

# ===== 6. 함수 정의 =====
print("6. 함수 정의")

def greet(name):
    return f"Hello, {name}!"

print(greet("Python"))
print()

# ===== 7. 리스트 & 딕셔너리 =====
print("7. 리스트 & 딕셔너리")

fruits = ["apple", "banana", "cherry"]
person = {"name": "Alice", "age": 25}

print("- 리스트:")
for fruit in fruits:
    print(f"  {fruit}")

print("\n- 딕셔너리:")
for key, value in person.items():
    print(f"  {key}: {value}")
print()

# ===== 8. 람다 & 고차 함수 =====
print("8. 람다 & 고차 함수")

nums = [1, 2, 3, 4]
squared = list(map(lambda x: x**2, nums))
print(f"제곱된 리스트: {squared}\n")

# ===== 9. 예외 처리 =====
print("9. 예외 처리")

try:
    val = int("10a")
except ValueError as e:
    print(f"에러 발생: {e}\n")

# ===== 10. 모듈과 패키지 =====
print("10. 모듈과 패키지")

import math
print(f"math 모듈의 pi: {math.pi}")

from datetime import datetime
now = datetime.now()
print(f"현재 시각: {now}")
