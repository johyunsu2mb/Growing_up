// ============================================================================
// C++ 주요 개념 정리
// 이 코드는 C 언어의 기본 개념들을 설명하고 예시로 보여줍니다.
// ============================================================================

#include <iostream>     // C++ 표준 입출력 스트림 사용
#include <string>       // string 클래스 사용
#include <vector>       // vector 컨테이너 사용
using namespace std;

// ===== 함수 선언부 =====
int get_max(int a, int b);      // 두 정수 중 큰 값을 반환하는 함수
void demonstrate_operators();   // 연산자 시연 함수
void demonstrate_arrays();      // 배열 시연 함수
void demonstrate_pointers();    // 포인터 시연 함수

// ===== 메인 함수 =====
int main() {
    cout << "===== C++ 주요 개념 정리 =====\n\n";

    // ----- 1. 기본 데이터 타입 -----
    cout << "1. 기본 데이터 타입\n";

    int i = 10;
    float f = 3.14f;
    double d = 3.141592;
    char c = 'A';
    bool b = true;

    cout << "정수(int): " << i << endl;
    cout << "실수(float): " << f << endl;
    cout << "실수(double): " << d << endl;
    cout << "문자(char): " << c << " (ASCII: " << (int)c << ")" << endl;
    cout << "불리언(bool): " << b << " (1=참, 0=거짓)\n\n";

    // ----- 2. 입력 예제 -----
    cout << "2. 입력 예제\n";

    int user_input;
    cout << "정수를 입력하세요: ";
    cin >> user_input;
    cout << "입력한 정수: " << user_input << "\n\n";

    // ----- 3. 조건문 -----
    cout << "3. 조건문 예제\n";
    if (user_input > 0) {
        cout << user_input << "는 양수입니다.\n";
    } else if (user_input < 0) {
        cout << user_input << "는 음수입니다.\n";
    } else {
        cout << user_input << "는 0입니다.\n";
    }

    // ----- 4. switch-case 문 -----
    cout << "\n4. switch-case 문 예제\n";
    switch (user_input % 3) {
        case 0:
            cout << user_input << "는 3의 배수입니다.\n";
            break;
        case 1:
            cout << user_input << "를 3으로 나눈 나머지는 1입니다.\n";
            break;
        case 2:
            cout << user_input << "를 3으로 나눈 나머지는 2입니다.\n";
            break;
        default:
            cout << "예상치 못한 오류가 발생했습니다.\n";
            break;
    }

    // ----- 5. 반복문 -----
    cout << "\n5. 반복문 예제\n";
    cout << "\n- for 반복문:\n";
    for (int count = 1; count <= 5; count++) {
        cout << "  for 반복 " << count << "번째\n";
        if (count % 2 == 0) {
            cout << "  (count가 짝수여서 continue 실행)\n";
            continue;
        }
        cout << "  count가 홀수일 때만 실행되는 코드\n";
        if (count == 3) {
            cout << "  (count가 3이어서 break 실행)\n";
            break;
        }
    }

    cout << "\n- while 반복문:\n";
    int while_count = 1;
    while (while_count <= 3) {
        cout << "  while 반복 " << while_count << "번째\n";
        while_count++;
    }

    cout << "\n- do-while 반복문:\n";
    int do_count = 1;
    do {
        cout << "  do-while 반복 " << do_count << "번째\n";
        do_count++;
    } while (do_count <= 3);

    // ----- 6. 함수 호출 -----
    cout << "\n6. 함수 호출 예제\n";
    int num1 = 15, num2 = 25;
    int max_value = get_max(num1, num2);
    cout << num1 << "와 " << num2 << " 중 큰 값: " << max_value << "\n\n";

    // ----- 7 ~ 9 기능 호출 -----
    demonstrate_operators();
    demonstrate_arrays();
    demonstrate_pointers();

    cout << "\n===== 프로그램 종료 =====\n";
    return 0;
}

// ===== 함수 정의부 =====
int get_max(int a, int b) {
    return (a > b) ? a : b;
}

void demonstrate_operators() {
    cout << "7. 연산자 시연\n";
    int a = 10, b = 3;
    cout << "\n- 산술 연산자:\n";
    cout << "  a = " << a << ", b = " << b << endl;
    cout << "  덧셈: " << (a + b) << endl;
    cout << "  뺄셈: " << (a - b) << endl;
    cout << "  곱셈: " << (a * b) << endl;
    cout << "  나눗셈: " << (a / b) << endl;
    cout << "  나머지: " << (a % b) << endl;
}

void demonstrate_arrays() {
    cout << "\n8. 배열 시연\n";
    vector<int> arr = {10, 20, 30, 40, 50};
    cout << "- 벡터 요소 출력:\n";
    for (int val : arr) {
        cout << "  " << val;
    }
    cout << endl;

    string str = "Hello";
    cout << "- 문자열 출력: " << str << endl;
}

void demonstrate_pointers() {
    cout << "\n9. 포인터 시연\n";
    int x = 42;
    int* ptr = &x;
    cout << "- 포인터 주소: " << ptr << ", 값: " << *ptr << endl;
}
