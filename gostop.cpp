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

        for (int k = 0; k < 4; ++k) {
            cout << k + 1 << "번 패= " << i[k] << endl;
        }

        int a = i[0], b = i[1], c = i[2], d = i[3];

        string m1 = (a == b ? "땡" : "끗");
        string m2 = (c == d ? "땡" : "끗");

        int s1 = (m1 == "땡") * (10 + a) + (m1 != "땡") * ((a + b >= 11) ? (a + b - 10) : (a + b));
        int s2 = (m2 == "땡") * (10 + c) + (m2 != "땡") * ((c + d >= 11) ? (c + d - 10) : (c + d));

        int s1_display = (m1 == "땡") * a + (m1 != "땡") * s1;
        int s2_display = (m2 == "땡") * c + (m2 != "땡") * s2;

        cout << "1번 플레이어: " << s1_display << m1 << endl;
        cout << "2번 플레이어: " << s2_display << m2 << endl;

        string winner[] = { "무승부!", "1번 플레이어 승리!", "2번 플레이어 승리!" };
        int cmp = (s1 > s2) * 1 + (s2 > s1) * 2;
        cout << winner[cmp] << endl;

        cout << "재시작 y/n : ";
        cin >> re;
        i[0] = (re == "y") * 1; 
    }

    return 0;
}
#include <random>
#include <iostream>
#include <string>
using namespace std;

int main() {
    const int NUM_PLAYERS = 4;
    int cards[NUM_PLAYERS * 2]; // 2 cards per player
    string re;

    random_device rd;
    mt19937 engine(rd());
    uniform_int_distribution<int> distrib(1, 10);

    bool game_running = true;

    while (game_running) {
        bool valid = false;

            // 내부 루프 수정: 조건을 하나로 합침
    while (!valid) {
        int count[11] = {};
        valid = true;
    
        for (int i = 0; i < NUM_CARDS; ++i) {
            cards[i] = distrib(engine);
            count[cards[i]]++;
            valid = valid && (count[cards[i]] <= 2); // 체크 바로 반영
        }
    
        // 중복 카드쌍 검사
        for (int i = 0; i < NUM_PLAYERS && valid; ++i) {
            for (int j = i + 1; j < NUM_PLAYERS; ++j) {
                int a1 = cards[i * 2], a2 = cards[i * 2 + 1];
                int b1 = cards[j * 2], b2 = cards[j * 2 + 1];
                valid = valid && !((a1 == b1 && a2 == b2) || (a1 == b2 && a2 == b1));
            }
        }
    }


        int score[NUM_PLAYERS];
        string msg[NUM_PLAYERS];

        for (int i = 0; i < NUM_PLAYERS; ++i) {
            int a = cards[i * 2], b = cards[i * 2 + 1];
            msg[i] = (a == b ? "땡" : "끗");
            score[i] = (msg[i] == "땡") * (10 + a) + (msg[i] != "땡") * ((a + b > 10) ? (a + b - 10) : (a + b));

            int display = (msg[i] == "땡") ? a : score[i];

            cout << i + 1 << "번 플레이어 패: " << a << ", " << b << " -> " << display << msg[i] << endl;
        }

        // 승자 판별
        int winner_index = 0;
        for (int i = 1; i < NUM_PLAYERS; ++i)
            winner_index = (score[i] > score[winner_index]) ? i : winner_index;

        // 동점자 있는지 확인
        int tie = 0;
        for (int i = 0; i < NUM_PLAYERS; ++i)
            tie += (score[i] == score[winner_index]);

        cout << (tie > 1 ? "무승부!" : to_string(winner_index + 1) + "번 플레이어 승리!") << endl;

        cout << "재시작 y/n : ";
        cin >> re;
        game_running = (re == "y");
    }

    return 0;
}


#include <random>
#include <iostream>
#include <string>
using namespace std;

int main() {
    const int NUM_PLAYERS = 3;
    const int NUM_CARDS = NUM_PLAYERS * 2; 
    int cards[NUM_CARDS]; 
    string re;

    random_device rd;
    mt19937 engine(rd()); //랜덤 함수 안정화
    uniform_int_distribution<int> distrib(1, 10);

    bool game_running = true;

    while (game_running) {
        bool valid = false;

            // 내부 루프 수정
    while (!valid) {
        int count[11] = {};
        valid = true;
    
        for (int i = 0; i < NUM_CARDS; ++i) {
            cards[i] = distrib(engine);
            count[cards[i]]++;
            valid = valid && (count[cards[i]] <= 2);
        }
    
        // 중복 카드쌍 검사
        for (int i = 0; i < NUM_PLAYERS && valid; ++i) {
            for (int j = i + 1; j < NUM_PLAYERS; ++j) {
                int a1 = cards[i * 2], a2 = cards[i * 2 + 1];
                int b1 = cards[j * 2], b2 = cards[j * 2 + 1];
                valid = valid && !((a1 == b1 && a2 == b2) || (a1 == b2 && a2 == b1));
            }
        }
    }


        int score[NUM_PLAYERS];
        string msg[NUM_PLAYERS];

        for (int i = 0; i < NUM_PLAYERS; ++i) {
            int a = cards[i * 2], b = cards[i * 2 + 1];
            msg[i] = (a == b ? "땡" : "끗");
            score[i] = (msg[i] == "땡") * (10 + a) + (msg[i] != "땡") * ((a + b > 10) ? (a + b - 10) : (a + b));

            int display = (msg[i] == "땡") ? a : score[i];

            cout << i + 1 << "번 플레이어 패: " << a << ", " << b << " -> " << display << msg[i] << endl;
        }

        // 승자 판별
        int winner_index = 0;
        for (int i = 1; i < NUM_PLAYERS; ++i)
            winner_index = (score[i] > score[winner_index]) ? i : winner_index;

        // 동점자 있는지 확인
        int tie = 0;
        for (int i = 0; i < NUM_PLAYERS; ++i)
            tie += (score[i] == score[winner_index]);

        cout << (tie > 1 ? "무승부!" : to_string(winner_index + 1) + "번 플레이어 승리!") << endl;

        cout << "재시작 y/n : ";
        cin >> re;
        game_running = (re == "y");
    }

    return 0;
}
