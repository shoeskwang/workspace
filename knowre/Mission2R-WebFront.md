# KnowRe Video Interview

* Mission: Server/Client-based mathematics test application

* 클라이언트 (미완성 상태입니다)
  * 서버에서 JSON API를 통해 문제를 내려받아 렌더링해 줍니다.
  * 문제의 타입은 총 세 가지가 있으며, 객관식, 주관식이 있습니다.
  * JSON API 형식은 아래에 정의되어 있습니다.
  * 화면 모양은 아래 그림에 정의되어 있습니다.
  * **(추가사항) Submit 버튼을 눌러 서버에 답을 제출하면 서버로부터 채점 결과를 받아 유저에게 피드백을 줍니다.**

* 서버 (완성된 상태입니다)
  * 클라이언트의 요청에 따라 SQLite DB로부터 문제를 내려받아 클라이언트에게 JSON API 형태로 전달해 줍니다.
  * 클라이언트의 채점 요청을 받아 채점을 한 후, JSON API 형태로 채점결과를 전달해 주고, 채점 결과는 DB에 저장합니다.
  * node.js 이외의 언어를 이용하실 경우, SQLite DB에 들어가야 할 데이터는 첨부드린 파일에 같이 있습니다.
  * DB의 스키마는 아래에 정의되어 있습니다.

* 주의사항
  * 라이브러리나 프레임워크는 자유롭게 사용하실 수 있습니다. Webpack 등의 번들링 역시 자유롭게 설정하시면 됩니다.
  * 시간이 촉박할 수도 있으나, 완성도보다는 어떤 식으로 실무에 접근하는지를 보기 위함이니 부담갖지 않으셔도 됩니다..!

* JSON API
  * `GET /api/fetchProblem`: No input

    ```
    {
      problems: [
          {
              id: 1,            // Problem ID
              problem_text: '1 + 1 = ?',  // 문제 본문, String
              type: 1,          // 문제 형식, 1: 객관식, 2: 주관식
              choices: "[1,2,3,4,5]"    // 객관식 보기, Stringified JSON
          },
          // ...
      ]
    }
    ```

  * **(추가사항)** `POST /api/submit`: Input with `x-www-form-urlencoded`
    * Input: key is `input`, value is Stringified JSON

        ```
        [
            {
                id: 1,
                answer: "2",        // 답안, String(객관식일 경우 0번째 보기가 1번)
            },
            // ...
        ]
        ```

    * Output

        ```
        {
            results: [
                {
                    id: 1,
                    result: true,       // 답안 결과, Boolean
                    answer: "2"         // 정답, String(객관식일 경우 0번째 보기가 1번)
                },
                // ...
            ]
        }
        ```

* DB Schema
  * `problems` table
    * `problem_text`: `Text`  // 문제 본문
    * `type`: `Int`       // 문제 형식, 1: 객관식, 2: 주관식
    * `choices`: `Text`     // 객관식 보기, Stringified JSON
    * `answer`: `Text`      // 정답, String(객관식일 경우 0번째 보기가 1번)
  * `results` table
    * `problem_id`: `Int`   // 문제 ID
    * `answer`: `Text`      // 제출된 정답
    * `result`: `Int`     // 결과, 0: 오답, 1: 정답
* 클라이언트 화면
  * [ClientLayout.pdf](ClientLayout.pdf)
* DB Data
  * [database.json](database.json)

