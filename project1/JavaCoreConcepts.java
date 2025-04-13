/*
 * Java 언어 핵심 개념 정리 (1-13)
 * 기본 데이터 타입, 연산자, 조건문, 반복문, 배열, 클래스와 객체,
 * 상속, 다형성, 인터페이스, 추상 클래스, 컬렉션, 예외 처리, 파일 입출력, 제네릭, 람다 표현식
 */
package project1;
//필요한 패키지 가져오기
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//Java의 기본 개념을 설명하는 클래스
public class JavaCoreConcepts {
	// 클래스 변수(정적 변수) - 모든 객체가 공유하는 변수
    static int classVariable = 10;
    
    // 인스턴스 변수 - 객체마다 별도로 가지는 변수
    private int instanceVariable;
    private String name;
    
    // 상수 선언 - 값이 변경되지 않는 변수 (대문자와 밑줄로 명명)
    public static final double PI = 3.14159;
    
    
    //기본 생성자
    public JavaCoreConcepts() {
        this.instanceVariable = 0;
        this.name = "Default";
        System.out.println("기본 생성자 호출됨");
    }
    
    
    //매개변수가 있는 생성자
    public JavaCoreConcepts(int instanceVariable, String name) {
        this.instanceVariable = instanceVariable;
        this.name = name;
        System.out.println("매개변수가 있는 생성자 호출됨: " + name);
    }
    
    
    //Getter 메서드
    public int getInstanceVariable() {
        return instanceVariable;
    }
    
    
    //Setter 메서드
    public void setInstanceVariable(int value) {
        this.instanceVariable = value;
    }
    
    
    //객체의 문자열 표현을 반환
    @Override
    public String toString() {
        return "JavaBasicConcepts{name='" + name + "', instanceVariable=" + instanceVariable + "}";
    }
    
    
    //정적 메서드 예제
    public static int add(int a, int b) {
        return a + b;
    }
    
    
    //인스턴스 메서드 예제
    public void showMessage(String message) {
        System.out.println(name + "의 메시지: " + message);
    }
    
    
    //메서드 오버로딩 예제 - 정수
    public int calculate(int a, int b) {
        return a + b;
    }
    
    
    //메서드 오버로딩 예제 - 실수
    public double calculate(double a, double b) {
        return a * b;
    }
    
    
    //가변 인자를 받는 메서드
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    public static void main(String[] args) {
        System.out.println("====== Java 핵심 개념 정리 ======\n");
     // ----- 1. 기본 데이터 타입 -----
        demonstrateDataTypes();
        
        // ----- 2. 연산자 -----
        demonstrateOperators();
        
        // ----- 3. 조건문 -----
        demonstrateConditionals();
        
        // ----- 4. 반복문 -----
        demonstrateLoops();
        
        // ----- 5. 배열 -----
        demonstrateArrays();
        
        // ----- 6. 클래스와 객체 -----
        demonstrateClassesAndObjects();
        
        // 7. 상속과 다형성
        demonstrateInheritanceAndPolymorphism();
        
        // 8. 인터페이스와 추상 클래스
        demonstrateInterfacesAndAbstractClasses();
        
        // 9. 컬렉션 프레임워크
        demonstrateCollections();
        
        // 10. 예외 처리
        demonstrateExceptionHandling();
        
        // 11. 파일 입출력
        demonstrateFileIO();
        
        // 12. 제네릭
        demonstrateGenerics();
        
        // 13. 람다 표현식과 함수형 인터페이스
        demonstrateLambdaAndFunctionalInterfaces();
        
        System.out.println("\n====== 프로그램 종료 ======");
    }
    
    /**
     * 1. 기본 데이터 타입 설명
     */
    private static void demonstrateDataTypes() {
        System.out.println("1. 기본 데이터 타입");
        
        // 정수형 타입
        byte b = 127;                // 8비트, -128 ~ 127
        short s = 32767;             // 16비트, -32,768 ~ 32,767
        int i = 2147483647;          // 32비트, -2,147,483,648 ~ 2,147,483,647
        long l = 9223372036854775807L; // 64비트, 매우 큰 범위 (L 접미사 필요)
        
        // 실수형 타입
        float f = 3.14f;             // 32비트 부동소수점 (f 접미사 필요)
        double d = 3.14159265359;    // 64비트 부동소수점
        
        // 문자형 타입
        char c = 'A';                // 16비트 유니코드 문자
        
        // 논리형 타입
        boolean bool = true;         // true 또는 false
        
        // 문자열 (참조 타입)
        String str = "Hello, Java!";
        
        System.out.println("  byte: " + b);
        System.out.println("  short: " + s);
        System.out.println("  int: " + i);
        System.out.println("  long: " + l);
        System.out.println("  float: " + f);
        System.out.println("  double: " + d);
        System.out.println("  char: " + c + " (ASCII: " + (int)c + ")");
        System.out.println("  boolean: " + bool);
        System.out.println("  String: " + str);
        
        // 타입 변환
        int intValue = (int)d;       // 명시적 형변환(Explicit casting): double -> int
        double doubleValue = i;      // 암시적 형변환(Implicit casting): int -> double
        
        System.out.println("\n  형변환:");
        System.out.println("  double(" + d + ") -> int: " + intValue);
        System.out.println("  int(" + i + ") -> double: " + doubleValue);
        
        System.out.println();
    }
    
    /**
     * 2. 연산자 설명
     */
    private static void demonstrateOperators() {
        System.out.println("2. 연산자");
        
        // 산술 연산자
        int a = 10, b = 3;
        System.out.println("\n  산술 연산자:");
        System.out.println("  a = " + a + ", b = " + b);
        System.out.println("  덧셈(a + b): " + (a + b));
        System.out.println("  뺄셈(a - b): " + (a - b));
        System.out.println("  곱셈(a * b): " + (a * b));
        System.out.println("  나눗셈(a / b): " + (a / b) + " (정수 나눗셈은 소수점 버림)");
        System.out.println("  나머지(a % b): " + (a % b));
        
        // 증감 연산자
        int c = 5;
        System.out.println("\n  증감 연산자:");
        System.out.println("  c = " + c);
        System.out.println("  전위 증가(++c): " + (++c) + " (증가 후 값 사용)");
        System.out.println("  후위 증가(c++): " + (c++) + " (값 사용 후 증가)");
        System.out.println("  증가 후 c의 값: " + c);
        
        // 관계 연산자
        System.out.println("\n  관계 연산자:");
        System.out.println("  a == b: " + (a == b));
        System.out.println("  a != b: " + (a != b));
        System.out.println("  a > b: " + (a > b));
        System.out.println("  a < b: " + (a < b));
        System.out.println("  a >= b: " + (a >= b));
        System.out.println("  a <= b: " + (a <= b));
        
        // 논리 연산자
        boolean p = true, q = false;
        System.out.println("\n  논리 연산자:");
        System.out.println("  p = " + p + ", q = " + q);
        System.out.println("  논리곱(p && q): " + (p && q) + " (둘 다 참이면 참)");
        System.out.println("  논리합(p || q): " + (p || q) + " (하나라도 참이면 참)");
        System.out.println("  논리부정(!p): " + (!p) + " (참이면 거짓, 거짓이면 참)");
        
        // 비트 연산자
        int x = 5;  // 0000 0101
        int y = 3;  // 0000 0011
        System.out.println("\n  비트 연산자:");
        System.out.println("  x = " + x + " (이진수: " + Integer.toBinaryString(x) + ")");
        System.out.println("  y = " + y + " (이진수: " + Integer.toBinaryString(y) + ")");
        System.out.println("  비트 AND(x & y): " + (x & y) + " (이진수: " + Integer.toBinaryString(x & y) + ")");
        System.out.println("  비트 OR(x | y): " + (x | y) + " (이진수: " + Integer.toBinaryString(x | y) + ")");
        System.out.println("  비트 XOR(x ^ y): " + (x ^ y) + " (이진수: " + Integer.toBinaryString(x ^ y) + ")");
        System.out.println("  비트 NOT(~x): " + (~x) + " (이진수: " + Integer.toBinaryString(~x & 0xff) + ")");
        System.out.println("  왼쪽 시프트(x << 1): " + (x << 1) + " (이진수: " + Integer.toBinaryString(x << 1) + ")");
        System.out.println("  오른쪽 시프트(x >> 1): " + (x >> 1) + " (이진수: " + Integer.toBinaryString(x >> 1) + ")");
        
        // 대입 연산자
        int z = 10;
        System.out.println("\n  복합 대입 연산자:");
        System.out.println("  z = " + z);
        z += 5;  // z = z + 5와 동일
        System.out.println("  z += 5 실행 후: " + z);
        z -= 2;  // z = z - 2와 동일
        System.out.println("  z -= 2 실행 후: " + z);
        
        // 삼항 연산자
        int max = (a > b) ? a : b;
        System.out.println("\n  삼항 연산자:");
        System.out.println("  (a > b) ? a : b = " + max);
        
        System.out.println();
    }
    
    /**
     * 3. 조건문 설명
     */
    private static void demonstrateConditionals() {
        System.out.println("3. 조건문");
        
        int value = 5;
        
        // if 문
        System.out.println("\n  if 문:");
        if (value > 0) {
            System.out.println("  " + value + "는 양수입니다.");
        }
        
        // if-else 문
        System.out.println("\n  if-else 문:");
        if (value % 2 == 0) {
            System.out.println("  " + value + "는 짝수입니다.");
        } else {
            System.out.println("  " + value + "는 홀수입니다.");
        }
        
        // if-else if-else 문
        System.out.println("\n  if-else if-else 문:");
        if (value > 10) {
            System.out.println("  " + value + "는 10보다 큽니다.");
        } else if (value < 10) {
            System.out.println("  " + value + "는 10보다 작습니다.");
        } else {
            System.out.println("  " + value + "는 10과 같습니다.");
        }
        
        // switch 문
        System.out.println("\n  switch 문:");
        switch (value) {
            case 1:
                System.out.println("  값은 1입니다.");
                break;
            case 5:
                System.out.println("  값은 5입니다.");
                break;
            case 10:
                System.out.println("  값은 10입니다.");
                break;
            default:
                System.out.println("  값은 1, 5, 10이 아닙니다.");
                break;
        }
        
        System.out.println();
    }
    
    /**
     * 4. 반복문 설명
     */
    private static void demonstrateLoops() {
        System.out.println("4. 반복문");
        
        // for 반복문
        System.out.println("\n  for 반복문:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("  for 반복 " + i + "번째");
        }
        
        // while 반복문
        System.out.println("\n  while 반복문:");
        int j = 1;
        while (j <= 3) {
            System.out.println("  while 반복 " + j + "번째");
            j++;
        }
        
        // do-while 반복문
        System.out.println("\n  do-while 반복문:");
        int k = 1;
        do {
            System.out.println("  do-while 반복 " + k + "번째");
            k++;
        } while (k <= 3);
        
        // 향상된 for 반복문 (for-each)
        System.out.println("\n  향상된 for 반복문 (for-each):");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println("  배열 요소: " + num);
        }
        
        // break로 반복문 종료
        System.out.println("\n  break 사용:");
        for (int i = 1; i <= 10; i++) {
            if (i == 4) {
                System.out.println("  i가 4일 때 반복문 종료");
                break;
            }
            System.out.println("  현재 값: " + i);
        }
        
        // continue로 현재 반복 건너뛰기
        System.out.println("\n  continue 사용:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("  i가 3일 때 현재 반복 건너뛰기");
                continue;
            }
            System.out.println("  현재 값: " + i);
        }
        
        System.out.println();
    }
    
    /**
     * 5. 배열 설명
     */
    private static void demonstrateArrays() {
        System.out.println("5. 배열");
        
        // 1차원 배열
        System.out.println("\n  1차원 배열:");
        
        // 배열 선언과 동시에 초기화
        int[] numbers = {10, 20, 30, 40, 50};
        
        // 배열 선언 후 초기화
        int[] scores = new int[3];
        scores[0] = 85;
        scores[1] = 90;
        scores[2] = 95;
        
        // 배열 순회
        System.out.println("  numbers 배열 요소:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("    [" + i + "]: " + numbers[i]);
        }
        
        // 2차원 배열
        System.out.println("\n  2차원 배열:");
        
        // 2차원 배열 선언과 초기화
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // 2차원 배열 순회
        System.out.println("  matrix 배열 (3x3):");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("    ");
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        
        // Arrays 클래스 사용
        System.out.println("\n  Arrays 클래스 사용:");
        int[] sortArray = {5, 2, 9, 1, 3};
        System.out.println("  정렬 전: " + Arrays.toString(sortArray));
        Arrays.sort(sortArray);
        System.out.println("  정렬 후: " + Arrays.toString(sortArray));
        
        // 배열 복사
        int[] copied = Arrays.copyOf(numbers, numbers.length);
        System.out.println("  배열 복사: " + Arrays.toString(copied));
        
        System.out.println();
    }
    
    /**
     * 6. 클래스와 객체 설명
     */
    private static void demonstrateClassesAndObjects() {
        System.out.println("6. 클래스와 객체");
        
        // 객체 생성
        JavaCoreConcepts obj1 = new JavaCoreConcepts();  // 기본 생성자 사용
        JavaCoreConcepts obj2 = new JavaCoreConcepts(20, "Object 2");  // 매개변수가 있는 생성자 사용
        
        // 인스턴스 변수 접근
        System.out.println("\n  기본 생성자로 생성된 객체: " + obj1);
        System.out.println("  매개변수 생성자로 생성된 객체: " + obj2);
        
        // Setter 호출
        obj1.setInstanceVariable(15);
        System.out.println("\n  Setter 호출 후: " + obj1);
        
        // Getter 호출
        System.out.println("  obj2의 instanceVariable 값: " + obj2.getInstanceVariable());
        
        // 정적 변수 접근
        System.out.println("\n  정적 변수 접근:");
        System.out.println("  classVariable = " + JavaCoreConcepts.classVariable);
        
        // 인스턴스 메서드 호출
        System.out.println("\n  인스턴스 메서드 호출:");
        obj1.showMessage("Hello from instance method!");
        
        // 정적 메서드 호출
        System.out.println("\n  정적 메서드 호출:");
        int sum = JavaCoreConcepts.add(10, 20);
        System.out.println("  add(10, 20) = " + sum);
        
        // 메서드 오버로딩
        System.out.println("\n  메서드 오버로딩:");
        System.out.println("  calculate(5, 3) = " + obj1.calculate(5, 3));
        System.out.println("  calculate(2.5, 3.7) = " + obj1.calculate(2.5, 3.7));
        
        // 가변 인자 메서드
        System.out.println("\n  가변 인자 메서드:");
        System.out.println("  sum(1, 2, 3, 4, 5) = " + JavaCoreConcepts.sum(1, 2, 3, 4, 5));
        
        System.out.println();
    }

    
    /**
     * 7. 상속과 다형성 시연
     */
    private static void demonstrateInheritanceAndPolymorphism() {
        System.out.println("7. 상속과 다형성");
        
        // 객체 생성
        Animal animal = new Animal("일반 동물");
        Dog dog = new Dog("바둑이", "치와와");
        Cat cat = new Cat("나비", 7);
        
        // 메서드 호출
        System.out.println("\n  기본 메서드 호출:");
        animal.makeSound();  // Animal의 makeSound() 호출
        dog.makeSound();     // Dog의 오버라이딩된 makeSound() 호출
        cat.makeSound();     // Cat의 오버라이딩된 makeSound() 호출
        
        // 자식 클래스의 고유 메서드
        System.out.println("\n  자식 클래스의 고유 메서드:");
        dog.fetch();
        cat.climb();
        
        // 다형성
        System.out.println("\n  다형성 (상위 타입 변수로 하위 타입 객체 참조):");
        Animal dogAsAnimal = new Dog("멍멍이", "리트리버");
        Animal catAsAnimal = new Cat("야옹이", 5);
        
        // 동적 바인딩 - 실행 시점에 실제 객체 타입의 메서드 호출
        dogAsAnimal.makeSound();  // Dog의 makeSound() 호출
        catAsAnimal.makeSound();  // Cat의 makeSound() 호출
        
        // instanceof 연산자
        System.out.println("\n  instanceof 연산자와 타입 캐스팅:");
        if (dogAsAnimal instanceof Dog) {
            Dog castedDog = (Dog) dogAsAnimal;  // 다운캐스팅
            System.out.println("  Dog로 캐스팅 성공");
            castedDog.fetch();  // Dog 클래스의 고유 메서드 호출
        }
        
        System.out.println();
    }
    
    /**
     * 8. 인터페이스와 추상 클래스 시연
     */
    private static void demonstrateInterfacesAndAbstractClasses() {
        System.out.println("8. 인터페이스와 추상 클래스");
        
        // 추상 클래스는 직접 인스턴스화할 수 없음
        // Shape shape = new Shape(); // 오류 발생
        
        // 추상 클래스를 구현한 구체 클래스의 인스턴스 생성
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        
        // 추상 메서드 호출
        System.out.println("\n  추상 메서드 구현 호출:");
        System.out.println("  원의 면적: " + circle.calculateArea());
        System.out.println("  사각형의 면적: " + rectangle.calculateArea());
        
        // 추상 클래스의 일반 메서드 호출
        System.out.println("\n  추상 클래스의 일반 메서드 호출:");
        circle.displayInfo();
        rectangle.displayInfo();
        
        // 인터페이스 구현 클래스의 인스턴스 생성
        ElectricCar electricCar = new ElectricCar();
        GasCar gasCar = new GasCar();
        
        // 인터페이스 메서드 호출
        System.out.println("\n  인터페이스 메서드 호출:");
        electricCar.start();
        electricCar.stop();
        electricCar.charge();
        
        gasCar.start();
        gasCar.stop();
        gasCar.refuel();
        
        // 다형성을 활용한 인터페이스 사용
        System.out.println("\n  인터페이스를 통한 다형성:");
        Vehicle[] vehicles = {electricCar, gasCar};
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            
            // 특정 인터페이스 구현 여부 확인 및 형변환
            if (vehicle instanceof Chargeable) {
                ((Chargeable) vehicle).charge();
            }
            
            if (vehicle instanceof Refuelable) {
                ((Refuelable) vehicle).refuel();
            }
        }
        
        System.out.println();
    }
    
    /**
     * 9. 컬렉션 프레임워크 시연
     */
    private static void demonstrateCollections() {
        System.out.println("9. 컬렉션 프레임워크");
        
        // ArrayList (동적 배열)
        System.out.println("\n  ArrayList 예제:");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        
        System.out.println("  fruits 리스트: " + fruits);
        System.out.println("  첫 번째 과일: " + fruits.get(0));
        System.out.println("  리스트 크기: " + fruits.size());
        
        fruits.remove("바나나");
        System.out.println("  '바나나' 제거 후: " + fruits);
        
        // List 인터페이스
        System.out.println("\n  List 인터페이스 사용:");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        System.out.println("  리스트 순회:");
        for (int number : numbers) {
            System.out.println("    " + number);
        }
        
        // HashMap (키-값 쌍)
        System.out.println("\n  HashMap 예제:");
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        
        System.out.println("  Bob의 나이: " + ages.get("Bob"));
        System.out.println("  모든 사람: " + ages.keySet());
        
        // Map 인터페이스
        System.out.println("\n  Map 인터페이스 사용:");
        Map<String, String> capitals = new HashMap<>();
        capitals.put("대한민국", "서울");
        capitals.put("일본", "도쿄");
        capitals.put("중국", "베이징");
        
        System.out.println("  국가-수도 매핑:");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("    " + entry.getKey() + ": " + entry.getValue());
        }
        
        // HashSet (중복 없는 집합)
        System.out.println("\n  HashSet 예제:");
        HashSet<String> uniqueColors = new HashSet<>();
        uniqueColors.add("빨강");
        uniqueColors.add("파랑");
        uniqueColors.add("초록");
        uniqueColors.add("빨강");  // 중복 추가 시도
        
        System.out.println("  중복 제거 후 색상: " + uniqueColors);
        System.out.println("  '노랑' 포함 여부: " + uniqueColors.contains("노랑"));
        
        // Set 인터페이스
        System.out.println("\n  Set 인터페이스 사용:");
        Set<Integer> primeNumbers = new HashSet<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        
        System.out.println("  소수 집합: " + primeNumbers);
        
        System.out.println();
    }
    
    /**
     * 10. 예외 처리 시연
     */
    private static void demonstrateExceptionHandling() {
        System.out.println("10. 예외 처리");
        
        // try-catch 기본 사용
        System.out.println("\n  try-catch 예제:");
        try {
            int result = 10 / 0;  // ArithmeticException 발생
            System.out.println("  계산 결과: " + result);  // 이 코드는 실행되지 않음
        } catch (ArithmeticException e) {
            System.out.println("  예외 발생: " + e.getMessage());
        }
        
        // 다중 catch 블록
        System.out.println("\n  다중 catch 블록:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("  배열 요소: " + numbers[5]);  // ArrayIndexOutOfBoundsException 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  배열 인덱스 예외: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  일반 예외: " + e.getMessage());
        }
        
        // try-catch-finally
        System.out.println("\n  try-catch-finally 예제:");
        try {
            System.out.println("  try 블록 실행");
            String str = null;
            // str.length();  // NullPointerException 발생 (주석 해제 시)
        } catch (NullPointerException e) {
            System.out.println("  Null 참조 예외: " + e.getMessage());
        } finally {
            System.out.println("  finally 블록은 항상 실행됨");
        }
        
        // throws 키워드 사용 메서드 호출
        System.out.println("\n  throws 키워드 사용:");
        try {
            readFile("noexist.txt");  // 예외 발생 가능한 메서드 호출
        } catch (IOException e) {
            System.out.println("  파일 읽기 예외: " + e.getMessage());
        }
        
        // 사용자 정의 예외
        System.out.println("\n  사용자 정의 예외:");
        try {
            validateAge(-5);  // 사용자 정의 예외 발생
        } catch (InvalidAgeException e) {
            System.out.println("  유효하지 않은 나이: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * throws 키워드를 사용한 메서드 예제
     */
    private static void readFile(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        System.out.println("  파일 내용: " + line);
        reader.close();
    }
    
    /**
     * 사용자 정의 예외를 발생시키는 메서드
     */
    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("나이는 음수가 될 수 없습니다: " + age);
        }
        System.out.println("  유효한 나이: " + age);
    }
    
    /**
     * 11. 파일 입출력 시연
     */
    private static void demonstrateFileIO() {
        System.out.println("11. 파일 입출력");
        
        // 파일 쓰기
        try {
            System.out.println("\n  파일 쓰기 예제:");
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Java 파일 입출력 예제입니다.\n");
            writer.write("파일에 여러 줄을 작성할 수 있습니다.");
            writer.close();
            System.out.println("  'example.txt' 파일 쓰기 성공");
        } catch (IOException e) {
            System.out.println("  파일 쓰기 예외: " + e.getMessage());
        }
        
        // 파일 읽기
        try {
            System.out.println("\n  파일 읽기 예제:");
            File file = new File("example.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            String line;
            System.out.println("  파일 내용:");
            while ((line = reader.readLine()) != null) {
                System.out.println("    " + line);
            }
            
            reader.close();
        } catch (IOException e) {
            System.out.println("  파일 읽기 예외: " + e.getMessage());
        }
        
        // 파일 정보 확인
        File file = new File("example.txt");
        if (file.exists()) {
            System.out.println("\n  파일 정보:");
            System.out.println("  파일 이름: " + file.getName());
            System.out.println("  파일 경로: " + file.getAbsolutePath());
            System.out.println("  파일 크기: " + file.length() + " 바이트");
            System.out.println("  읽기 가능: " + file.canRead());
            System.out.println("  쓰기 가능: " + file.canWrite());
        }
        
        System.out.println();
    }
    
    /**
     * 12. 제네릭 시연
     */
    private static void demonstrateGenerics() {
        System.out.println("12. 제네릭");
        
        // 제네릭 클래스 사용
        System.out.println("\n  제네릭 클래스 예제:");
        Box<Integer> intBox = new Box<>(10);
        Box<String> stringBox = new Box<>("Hello Java");
        
        System.out.println("  정수 박스 값: " + intBox.getValue());
        System.out.println("  문자열 박스 값: " + stringBox.getValue());
        
        // 제네릭 메서드 사용
        System.out.println("\n  제네릭 메서드 예제:");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"A", "B", "C"};
        
        System.out.println("  첫 번째 정수: " + getFirstElement(intArray));
        System.out.println("  첫 번째 문자열: " + getFirstElement(stringArray));
        
        // 제네릭 타입 제한
        System.out.println("\n  제네릭 타입 제한 예제:");
        NumberBox<Integer> intNumberBox = new NumberBox<>(25);
        NumberBox<Double> doubleNumberBox = new NumberBox<>(3.14);
        
        System.out.println("  정수 박스 값: " + intNumberBox.getValue());
        System.out.println("  실수 박스 값: " + doubleNumberBox.getValue());
        
        // 와일드카드 사용
        System.out.println("\n  와일드카드 예제:");
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.14);
        doubleList.add(2.71);
        
        System.out.println("  정수 리스트 합: " + sumOfList(intList));
        System.out.println("  실수 리스트 합: " + sumOfList(doubleList));
        
        System.out.println();
    }
    
    /**
     * 제네릭 메서드 예제
     */
    private static <T> T getFirstElement(T[] array) {
        if (array != null && array.length > 0) {
            return array[0];
        }
        return null;
    }
    
    /**
     * 와일드카드를 사용한 제네릭 메서드
     */
    private static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    /**
     * 13. 람다 표현식과 함수형 인터페이스 시연
     */
    private static void demonstrateLambdaAndFunctionalInterfaces() {
        System.out.println("13. 람다 표현식과 함수형 인터페이스");
        
        // 람다 표현식 기본 사용
        System.out.println("\n  람다 표현식 기본 예제:");
        
        // 익명 클래스로 구현
        Runnable oldWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("  익명 클래스로 실행");
            }
        };
        
        // 람다 표현식으로 구현
        Runnable newWay = () -> System.out.println("  람다 표현식으로 실행");
        
        oldWay.run();
        newWay.run();
        
        // 매개변수가 있는 람다 표현식
        System.out.println("\n  매개변수가 있는 람다 표현식:");
        
        // 1개 매개변수
        Calculator addition = x -> x + x;
        System.out.println("  Addition(5): " + addition.calculate(5));
        
        // 2개 매개변수
        BiCalculator multiply = (x, y) -> x * y;
        System.out.println("  Multiply(3, 4): " + multiply.calculate(3, 4));
        
        // 블록이 있는 람다 표현식
        BiCalculator complex = (x, y) -> {
            int result = x + y;
            return result * 2;
        };
        System.out.println("  Complex(2, 3): " + complex.calculate(2, 3));
        
        // Java 표준 함수형 인터페이스
        System.out.println("\n  표준 함수형 인터페이스:");
        
        // Predicate: T -> boolean
        System.out.println("  Predicate 사용:");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("  10은 짝수인가? " + isEven.test(10));
        System.out.println("  7은 짝수인가? " + isEven.test(7));
        
        // Consumer: T -> void
        System.out.println("\n  Consumer 사용:");
        Consumer<String> printWithPrefix = message -> System.out.println("  결과: " + message);
        printWithPrefix.accept("Consumer 인터페이스 테스트");
        
        // Function: T -> R
        System.out.println("\n  Function 사용:");
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("  \"Hello\"의 길이: " + stringLength.apply("Hello"));
        
        // 람다 표현식을 사용한 리스트 처리
        System.out.println("\n  람다로 리스트 처리:");
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        // forEach와 람다
        System.out.println("  forEach 메서드:");
        names.forEach(name -> System.out.println("    " + name));
        
        // stream API와 람다
        System.out.println("\n  Stream API와 람다:");
        long count = names.stream()
                         .filter(name -> name.length() > 4)
                         .count();
        System.out.println("  이름 길이가 4보다 큰 항목 수: " + count);
        
        System.out.println();
    }
}

// 7. 상속과 다형성을 위한 클래스 정의
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println("  " + name + " 소리를 냅니다.");
    }
    
    @Override
    public String toString() {
        return "Animal(" + name + ")";
    }
}

class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name);  // 부모 클래스 생성자 호출
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println("  " + name + "(이)가 멍멍 짖습니다.");
    }
    
    public void fetch() {
        System.out.println("  " + name + "(이)가 물건을 가져옵니다.");
    }
    
    @Override
    public String toString() {
        return "Dog(" + name + ", " + breed + ")";
    }
}

class Cat extends Animal {
    private int lives;
    
    public Cat(String name, int lives) {
        super(name);
        this.lives = lives;
    }
    
    @Override
    public void makeSound() {
        System.out.println("  " + name + "(이)가 야옹 소리를 냅니다.");
    }
    
    public void climb() {
        System.out.println("  " + name + "(이)가 높은 곳을 올라갑니다.");
    }
    
    @Override
    public String toString() {
        return "Cat(" + name + ", 남은 생명: " + lives + ")";
    }
}

// 8. 인터페이스와 추상 클래스를 위한 정의

// 추상 클래스
abstract class Shape {
    // 추상 메서드 - 자식 클래스에서 반드시 구현해야 함
    public abstract double calculateArea();
    
    // 일반 메서드
    public void displayInfo() {
        System.out.println("  이 도형의 면적은 " + calculateArea() + "입니다.");
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

// 인터페이스
interface Vehicle {
    void start();
    void stop();
}

interface Chargeable {
    void charge();
}

interface Refuelable {
    void refuel();
}

class ElectricCar implements Vehicle, Chargeable {
    @Override
    public void start() {
        System.out.println("  전기차 시동을 켭니다.");
    }
    
    @Override
    public void stop() {
        System.out.println("  전기차 시동을 끕니다.");
    }
    
    @Override
    public void charge() {
        System.out.println("  전기차를 충전합니다.");
    }
}

class GasCar implements Vehicle, Refuelable {
    @Override
    public void start() {
        System.out.println("  가솔린차 시동을 켭니다.");
    }
    
    @Override
    public void stop() {
        System.out.println("  가솔린차 시동을 끕니다.");
    }
    
    @Override
    public void refuel() {
        System.out.println("  가솔린차에 연료를 주입합니다.");
    }
}

// 10. 사용자 정의 예외 클래스
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// 12. 제네릭 클래스 예제
class Box<T> {
    private T value;
    
    public Box(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
}

// 제네릭 타입 제한 예제 (Number 또는 그 하위 클래스만 허용)
class NumberBox<T extends Number> {
    private T value;
    
    public NumberBox(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public double getDoubleValue() {
        return value.doubleValue();
    }
}

// 13. 함수형 인터페이스 예제
@FunctionalInterface
interface Calculator {
    int calculate(int x);
}

@FunctionalInterface
interface BiCalculator {
    int calculate(int x, int y);
}