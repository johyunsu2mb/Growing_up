#include <random>
#include <iostream>
#include <string>
using namespace std;

int main() {
    int i[4];
    string re;
    random_device engine;
    uniform_int_distribution<int> distrib(1, 10);
    i[0] = 1;

    while(i[0]){

    while (true) {
        for (int k = 0; k < 4; ++k) {
            i[k] = distrib(engine);
        }

        if ((i[0] != i[2]) && (i[0] != i[3]) && (i[1] != i[2]) && (i[1] != i[3]))
            break;
    }

    for (int k = 0; k < 4; ++k) {
        cout << k+1 << "번 패= " << i[k] << endl;
    }

    int a = i[0], b = i[1];
    int c = i[2], d = i[3];

    string m1 = (a == b) ? "땡" : "끗";
    string m2 = (c == d) ? "땡" : "끗";

    int s1 = (m1 == "땡") ? (10 + a) : ((a + b >= 11) ? (a + b - 10) : (a + b));
    int s2 = (m2 == "땡") ? (10 + c) : ((c + d >= 11) ? (c + d - 10) : (c + d));

    int s1_display = (m1 == "땡") ? a : s1;
    int s2_display = (m2 == "땡") ? c : s2;

    cout << "1번 플레이어: " << s1_display << m1 << endl;
    cout << "2번 플레이어: " << s2_display << m2 << endl;

    if (s1 > s2)
        cout << "1번 플레이어 승리!" << endl;
    else if (s2 > s1)
        cout << "2번 플레이어 승리!" << endl;
    else
        cout << "무승부!" << endl;
        
    cout<<"재시작 y/n :";
    cin >> re;
    i[0] = re == "y" ? 1:0;
}
    return 0;
}
