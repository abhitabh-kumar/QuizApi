
# Quiz Backend Api

All apis request for Backend with SpringBoot


## Create New Quiz

POST method:

http://localhost:8080/quizzes/


send json file from body, like:

{

    "maxMarks":"50",

    "noOfQuestions":"11",

    "active":true
}
## Get All Active Quizzes

Get method:

http://localhost:8080/quizzes/active

Send all Active quizzes List, Like:

[

    {
        "qId": 6,
        "maxMarks": "30",
        "noOfQuestions": "10",
        "active": true
    },
    {
        "qId": 57,
        "maxMarks": "50",
        "noOfQuestions": "11",
        "active": true
    },
    {
        "qId": 5,
        "maxMarks": "20",
        "noOfQuestions": "5",
        "active": true
    },
    {
        "qId": 54,
        "maxMarks": "30",
        "noOfQuestions": "11",
        "active": true
    }
]
## Get All Quizzes

Get Method:

http://localhost:8080/quizzes/all

Send all Quiz Lists, like:

[
    
    {
        "qId": 53,
        "maxMarks": "30",
        "noOfQuestions": "11",
        "active": false
    },
    {
        "qId": 54,
        "maxMarks": "30",
        "noOfQuestions": "11",
        "active": true
    },
    {
        "qId": 55,
        "maxMarks": "30",
        "noOfQuestions": "11",
        "active": false
    },
    {
        "qId": 1,
        "maxMarks": null,
        "noOfQuestions": null,
        "active": false
    },
    {
        "qId": 5,
        "maxMarks": "20",
        "noOfQuestions": "5",
        "active": true
    },
    {
        "qId": 57,
        "maxMarks": "50",
        "noOfQuestions": "11",
        "active": true
    },
    {
        "qId": 2,
        "maxMarks": null,
        "noOfQuestions": null,
        "active": false
    },
    {
        "qId": 52,
        "maxMarks": "30",
        "noOfQuestions": "11",
        "active": false
    },
    {
        "qId": 3,
        "maxMarks": null,
        "noOfQuestions": null,
        "active": false
    },
    {
        "qId": 56,
        "maxMarks": "30",
        "noOfQuestions": "11",
        "active": false
    },
    {
        "qId": 4,
        "maxMarks": null,
        "noOfQuestions": null,
        "active": false
    },
    {
        "qId": 6,
        "maxMarks": "30",
        "noOfQuestions": "10",
        "active": true
    }
]
## Retrieve the Result of a Quiz by its ID

Get Method:

localhost:8080/quizzes/:{quizId}/result

Get results of That Quiz,Like:

[

    {
        "rId": 53,
        "marks": 12,
        "attempted": 3,
        "incorrect": 0,
        "correct": 3,
        "quiz": {
            "qId": 5,
            "maxMarks": "20",
            "noOfQuestions": "5",
            "active": false
        }
    }

]
