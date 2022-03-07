#language:ru
@test

Функционал: Тестирование сервиса Helpdesk
  - Создание нового тикета POST запросом с телом из json файла, значения которого заполняем сгенерированным значениями.
  - После создания нового тикета,с помощью GET запроса запрашиваем данного тикета и проверяем,
  что его данные соответствует данными из тела POST запроса

  Сценарий: Создание тикета POST запросом с высоким приоритетом

  # Первая часть теста - Создание тикета. Эти данные подставятся в тело запроса в шаблон тела файла createTicket.json
    # Генерится рандомная строка по маске
        # E - Английская буква,
        # R - русская буква,
        # D - цифра. Остальные символы игнорятся

    Когда сгенерировать переменные
      | due_date        | 2021-01-01               |
      | title           | EEEEEEEE                 |
      | created         | 2022-03-05T16:27:39.582Z |
      | modified        | 2022-03-05T16:27:39.582Z |
      | submitter_email | EEEEEEE@EEEDDD.EE        |
      | status          | 1                        |
      | on_hold         | true                     |
      | description     | RRRRRRRRRRRRRRRRRRR      |
      | resolution      | EEEEEEEE                 |
      | priority        | 1                        |
      | secret_key      | DDDEEEDDDEEE             |
      | queue           | 1                        |
      | kbitem          | 1                        |

 # Создаём тикет
    И создать запрос
      | method | path         | body              |
      | POST   | /api/tickets | createTicket.json |
    И добавить header
      | Content-Type | application/json |
    Тогда отправить запрос
    И статус код 201

    Когда извлечь данные
      | ticket_id              | $.id              |
      | ticket_due_date        | $.due_date        |
      | ticket_title           | $.title           |
      | ticket_created         | $.created         |
      | ticket_modified        | $.modified        |
      | ticket_submitter_email | $.submitter_email |
      | ticket_status          | $.status          |
      | ticket_on_hold         | $.on_hold         |
      | ticket_description     | $.description     |
      | ticket_resolution      | $.resolution      |
      | ticket_priority        | $.priority        |
      | ticket_secret_key      | $.secret_key      |
      | ticket_queue           | $.queue           |
      | ticket_kbitem          | $.kbitem          |

 # Сравниваем данные из тела POST запроса и тела ответа
    И сравнить значения

      | ${ticket_due_date}        | == | ${due_date}        |
      | ${ticket_title}           | == | ${title}           |
      | ${ticket_submitter_email} | == | ${submitter_email} |
      | ${ticket_status}          | == | ${status}          |
      | ${ticket_on_hold}         | == | ${on_hold}         |
      | ${ticket_description}     | == | ${description}     |
      | ${ticket_resolution}      | == | ${resolution}      |
      | ${ticket_priority}        | == | ${priority}        |
      | ${ticket_secret_key}      | == | ${secret_key}      |
      | ${ticket_queue}           | == | ${queue}           |
      | ${ticket_kbitem}          | == | ${kbitem}          |

        # Вторая часть теста - GET запрос тикета и проверка его данных
    Когда создать запрос
      | method | path                      |
      | GET    | /api/tickets/${ticket_id} |
    И добавить header
      | accept        | application/json                               |
      | Authorization | token c1803e6e3b12359683796496625e8518b2e082c3 |
    Тогда отправить запрос
    И статус код 200

    Когда извлечь данные
      | resp_id              | $.id              |
      | resp_due_date        | $.due_date        |
      | resp_title           | $.title           |
      | resp_created         | $.created         |
      | resp_modified        | $.modified        |
      | resp_submitter_email | $.submitter_email |
      | resp_status          | $.status          |
      | resp_on_hold         | $.on_hold         |
      | resp_description     | $.description     |
      | resp_resolution      | $.resolution      |
      | resp_priority        | $.priority        |
      | resp_secret_key      | $.secret_key      |
      | resp_queue           | $.queue           |
      | resp_kbitem          | $.kbitem          |

    # Сравниваем данные из тела запроса и тела ответа
    И сравнить значения
      | ${ticket_id}              | == | ${resp_id}              |
      | ${ticket_title}           | == | ${resp_title}           |
      | ${ticket_submitter_email} | == | ${resp_submitter_email} |
      | ${ticket_status}          | == | ${resp_status}          |
      | ${ticket_on_hold}         | == | ${resp_on_hold}         |
      | ${ticket_description}     | == | ${resp_description}     |
      | ${ticket_resolution}      | == | ${resp_resolution}      |
      | ${ticket_priority}        | == | ${resp_priority}        |
      | ${ticket_secret_key}      | == | ${resp_secret_key}      |
      | ${ticket_queue}           | == | ${resp_queue}           |
      | ${ticket_kbitem}          | == | ${resp_kbitem}          |









