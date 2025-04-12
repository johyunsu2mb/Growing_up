/*****************************************************************************
 * C 언어 주요 개념 정리
 * 이 코드는 C 언어의 기본 개념들을 설명하고 예시로 보여줍니다.
 *****************************************************************************/

 #include <stdio.h>   // 표준 입출력 함수(printf, scanf 등)를 사용하기 위한 헤더 파일
 #include <stdbool.h> // 불리언(bool) 자료형을 사용하기 위한 헤더 파일
 
 // ===== 함수 선언부 =====
 // 함수 원형 선언: 컴파일러에게 함수의 존재를 미리 알림
 // 반환타입 함수이름(매개변수 타입);
 int get_max(int a, int b);      // 두 정수 중 큰 값을 반환하는 함수
 void demonstrate_operators();   // 연산자 시연 함수
 void demonstrate_arrays();      // 배열 시연 함수
 void demonstrate_pointers();    // 포인터 시연 함수
 
 // ===== 메인 함수 =====
 // 모든 C 프로그램의 시작점
 int main() {
     printf("===== C 언어 주요 개념 정리 =====\n\n");
 
     // ----- 1. 기본 데이터 타입 -----
     printf("1. 기본 데이터 타입\n");
 
     int i = 10;             // 정수형 변수 (보통 4바이트, -2,147,483,648 ~ 2,147,483,647)
     float f = 3.14f;        // 단정밀도 부동소수점 (보통 4바이트)
     double d = 3.141592;    // 배정밀도 부동소수점 (보통 8바이트)
     char c = 'A';           // 문자형 (1바이트, ASCII 코드로 저장)
     bool b = true;          // 불리언 타입 (참/거짓)
 
     printf("정수(int): %d\n", i);
     printf("실수(float): %f\n", f);
     printf("실수(double): %lf\n", d);
     printf("문자(char): %c (ASCII: %d)\n", c, c);
     printf("불리언(bool): %d (1=참, 0=거짓)\n\n", b);
 
     // ----- 2. 입출력 함수 -----
     printf("2. 입출력 함수 예제\n");
 
     int user_input;
     printf("정수를 입력하세요: ");
     scanf("%d", &user_input);  // &: 변수의 메모리 주소를 전달 (포인터)
     printf("입력한 정수: %d\n\n", user_input);
 
     // ----- 3. 조건문 (if-else if-else) -----
     printf("3. 조건문 예제\n");
 
     if (user_input > 0) {
         printf("%d는 양수입니다.\n", user_input);
     } else if (user_input < 0) {
         printf("%d는 음수입니다.\n", user_input);
     } else {
         printf("%d는 0입니다.\n", user_input);
     }
 
     // ----- 4. switch-case 문 -----
     printf("\n4. switch-case 문 예제\n");
 
     switch (user_input % 3) {  // 3으로 나눈 나머지에 따라 분기
         case 0:
             printf("%d는 3의 배수입니다.\n", user_input);
             break;  // break가 없으면 다음 case로 진행됨 (fall-through)
         case 1:
             printf("%d를 3으로 나눈 나머지는 1입니다.\n", user_input);
             break;
         case 2:
             printf("%d를 3으로 나눈 나머지는 2입니다.\n", user_input);
             break;
         default:    // 어떤 case에도 해당하지 않을 때 실행
             printf("예상치 못한 오류가 발생했습니다.\n");
             break;
     }
 
     // ----- 5. 반복문 -----
     printf("\n5. 반복문 예제\n");
 
     // for 반복문 (초기식; 조건식; 증감식)
     printf("\n- for 반복문:\n");
     for (int count = 1; count <= 5; count++) {
         printf("  for 반복 %d번째\n", count);
 
         // continue 예제: 짝수일 때 아래 코드 건너뛰기
         if (count % 2 == 0) {
             printf("  (count가 짝수여서 continue 실행)\n");
             continue;  // 현재 반복의 나머지 부분을 건너뛰고 다음 반복으로
         }
 
         printf("  count가 홀수일 때만 실행되는 코드\n");
 
         // break 예제: count가 3일 때 반복문 종료
         if (count == 3) {
             printf("  (count가 3이어서 break 실행)\n");
             break;  // 반복문 즉시 종료
         }
     }
 
     // while 반복문
     printf("\n- while 반복문:\n");
     int while_count = 1;
     while (while_count <= 3) {
         printf("  while 반복 %d번째\n", while_count);
         while_count++;  // 증가하지 않으면 무한 루프 발생
     }
 
     // do-while 반복문 (조건과 상관없이 최소 1번은 실행됨)
     printf("\n- do-while 반복문:\n");
     int do_count = 1;
     do {
         printf("  do-while 반복 %d번째\n", do_count);
         do_count++;
     } while (do_count <= 3);
 
     // ----- 6. 함수 호출 -----
     printf("\n6. 함수 호출 예제\n");
 
     int num1 = 15, num2 = 25;
     int max_value = get_max(num1, num2);  // 함수 호출
     printf("%d와 %d 중 큰 값: %d\n\n", num1, num2, max_value);
 
     // ----- 7. 연산자 시연 -----
     demonstrate_operators();
 
     // ----- 8. 배열 시연 -----
     demonstrate_arrays();
 
     // ----- 9. 포인터 시연 -----
     demonstrate_pointers();
 
     printf("\n===== 프로그램 종료 =====\n");
     return 0;  // 프로그램 정상 종료 (0: 성공)
 }
 
 // ===== 함수 정의부 =====
 
 // 두 정수 중 큰 값을 반환하는 함수
 int get_max(int a, int b) {
     // 삼항 연산자: 조건 ? 참일_때_값 : 거짓일_때_값
     return (a > b) ? a : b;
 }
 
 // 연산자 시연 함수
 void demonstrate_operators() {
     printf("7. 연산자 시연\n");
 
     // 산술 연산자
     printf("\n- 산술 연산자:\n");
     int a = 10, b = 3;
     printf("  a = %d, b = %d\n", a, b);
     printf("  덧셈(a + b): %d\n", a + b);
     printf("  뺄셈(a - b): %d\n", a - b);
     printf("  곱셈(a * b): %d\n", a * b);
     printf("  나눗셈(a / b): %d (정수 나눗셈은 소수점 버림)\n", a / b);
     printf("  나머지(a %% b): %d\n", a % b);
 
     // 증감 연산자
     printf("\n- 증감 연산자:\n");
     int c = 5;
     printf("  c = %d\n", c);
     printf("  전위 증가(++c): %d (증가 후 값 사용)\n", ++c);
     printf("  후위 증가(c++): %d (값 사용 후 증가)\n", c++);
     printf("  증가 후 c의 값: %d\n", c);
 
     // 관계 연산자
     printf("\n- 관계 연산자:\n");
     printf("  a == b: %d (같으면 1, 다르면 0)\n", a == b);
     printf("  a != b: %d (다르면 1, 같으면 0)\n", a != b);
     printf("  a > b: %d\n", a > b);
     printf("  a < b: %d\n", a < b);
 
     // 논리 연산자
     printf("\n- 논리 연산자:\n");
     bool p = true, q = false;
     printf("  p = %d, q = %d\n", p, q);
     printf("  논리곱(p && q): %d (둘 다 참이면 참)\n", p && q);
     printf("  논리합(p || q): %d (하나라도 참이면 참)\n", p || q);
     printf("  논리부정(!p): %d (참이면 거짓, 거짓이면 참)\n", !p);
 
     // 비트 연산자
     printf("\n- 비트 연산자:\n");
     unsigned char x = 5;  // 0000 0101
     unsigned char y = 3;  // 0000 0011
     printf("  x = %d (이진수: 00000101), y = %d (이진수: 00000011)\n", x, y);
     printf("  비트 AND(x & y): %d\n", x & y);    // 0000 0001 = 1
     printf("  비트 OR(x | y): %d\n", x | y);     // 0000 0111 = 7
     printf("  비트 XOR(x ^ y): %d\n", x ^ y);    // 0000 0110 = 6
     printf("  비트 NOT(~x): %d\n", ~x & 0xFF);   // 1111 1010 = 250 (8비트로 제한)
     printf("  왼쪽 시프트(x << 1): %d\n", x << 1); // 0000 1010 = 10
     printf("  오른쪽 시프트(x >> 1): %d\n", x >> 1); // 0000 0010 = 2
 
     // 대입 연산자
     printf("\n- 복합 대입 연산자:\n");
     int z = 10;
     printf("  z = %d\n", z);
     z += 5;  // z = z + 5와 동일
     printf("  z += 5 실행 후: %d\n", z);
     z -= 2;  // z = z - 2와 동일
     printf("  z -= 2 실행 후: %d\n", z);
 }
 
 // 배열 시연 함수
 void demonstrate_arrays() {
     printf("\n8. 배열 시연\n");
 
     // 1차원 배열
     printf("\n- 1차원 배열:\n");
     int numbers[5] = {10, 20, 30, 40, 50};  // 배열 선언 및 초기화
     printf("  numbers 배열 요소: ");
     for (int i = 0; i < 5; i++) {
         printf("%d ", numbers[i]);  // 배열 요소 접근
     }
     printf("\n");
 
     // 문자열 (문자 배열)
     printf("\n- 문자열 (문자 배열):\n");
     char str[6] = "Hello";  // 문자열의 끝은 null 문자('\0')로 표시됨
     printf("  문자열: %s\n", str);
 
     printf("  문자별로 출력: ");
     for (int i = 0; str[i] != '\0'; i++) {
         printf("%c ", str[i]);
     }
     printf("\n");
 
     // 2차원 배열
     printf("\n- 2차원 배열:\n");
     int matrix[2][3] = {
         {1, 2, 3},
         {4, 5, 6}
     };
 
     printf("  matrix 배열 (2x3):\n");
     for (int row = 0; row < 2; row++) {
         printf("    ");
         for (int col = 0; col < 3; col++) {
             printf("%d ", matrix[row][col]);
         }
         printf("\n");
     }
 }
 
 // 포인터 시연 함수
 void demonstrate_pointers() {
     printf("\n9. 포인터 시연\n");
 
     // 기본 포인터
     int num = 42;
     int *ptr = &num;  // num의 메모리 주소를 저장
 
     printf("\n- 기본 포인터:\n");
     printf("  num의 값: %d\n", num);
     printf("  num의 주소: %p\n", &num);
     printf("  ptr의 값(num의 주소): %p\n", ptr);
     printf("  ptr이 가리키는 값(역참조): %d\n", *ptr);
 
     // 포인터를 통한 값 변경
     *ptr = 100;  // 포인터를 통해 num 값 변경
     printf("\n- 포인터로 값 변경 후:\n");
     printf("  num의 값: %d\n", num);
 
     // 포인터와 배열
     printf("\n- 포인터와 배열:\n");
     int arr[5] = {10, 20, 30, 40, 50};
     int *arr_ptr = arr;  // 배열 이름은 첫 요소의 주소
 
     printf("  arr 배열의 주소: %p\n", arr);
     printf("  arr_ptr의 값: %p\n", arr_ptr);
 
     printf("  배열 요소 접근:\n");
     for (int i = 0; i < 5; i++) {
         printf("    arr[%d] = %d, *(arr_ptr + %d) = %d\n",
                i, arr[i], i, *(arr_ptr + i));
     }
 
     // 함수 포인터 (간단한 예시)
     printf("\n- 함수 포인터:\n");
     int (*func_ptr)(int, int) = get_max;  // get_max 함수의 포인터
     int result = func_ptr(30, 20);  // 함수 포인터를 통한 함수 호출
     printf("  함수 포인터로 get_max(30, 20) 호출 결과: %d\n", result);
 }
 