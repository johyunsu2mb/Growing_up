#include <random>
#include <iostream>
#include <string>
using namespace std;

int main() {
    int i[5];  
    string re, result;

    random_device rd;
    mt19937 engine(rd()); // 고정된 난수 엔진
    uniform_int_distribution<int> distrib(1, 10);

    i[0] = 1;

    while (i[0]) {
        
        i[4] = 1;
        while (i[4]) {
            for (int k = 0; k < 4; ++k) {
                i[k] = distrib(engine);
            }
            i[4] = ((i[0] != i[2]) && (i[0] != i[3]) && (i[1] != i[2]) && (i[1] != i[3])) ? 0 : 1;
        }

        // 패 출력
        for (int k = 0; k < 4; ++k) {
            cout << k + 1 << "번 패= " << i[k] << endl;
        }

        int a = i[0], b = i[1], c = i[2], d = i[3];

        // 땡 / 끗 판별
        string m1 = (a == b ? "땡" : "끗");
        string m2 = (c == d ? "땡" : "끗");

        // 점수 계산
        int s1 = (m1 == "땡") * (10 + a) + (m1 != "땡") * ((a + b >= 11) ? (a + b - 10) : (a + b));
        int s2 = (m2 == "땡") * (10 + c) + (m2 != "땡") * ((c + d >= 11) ? (c + d - 10) : (c + d));

        // 출력용 점수 (땡이면 원래 수)
        int s1_display = (m1 == "땡") * a + (m1 != "땡") * s1;
        int s2_display = (m2 == "땡") * c + (m2 != "땡") * s2;

        cout << "1번 플레이어: " << s1_display << m1 << endl;
        cout << "2번 플레이어: " << s2_display << m2 << endl;

        // 승부 결과 (if 없이)
        string winner[] = { "무승부!", "1번 플레이어 승리!", "2번 플레이어 승리!" };
        int cmp = (s1 > s2) * 1 + (s2 > s1) * 2; // 0 = 무승부, 1 = s1승, 2 = s2승
        cout << winner[cmp] << endl;

        // 재시작 여부
        cout << "재시작 y/n : ";
        cin >> re;
        i[0] = (re == "y") * 1;  // y면 1, 아니면 0
    }

    return 0;
}
