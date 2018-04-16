Feature: User Certification
    Scenario: User is Passed 1
        Given that the user Vinod is given a task to clear Java certification exam 1
        When Vinod got 60 marks in exam
        Then Vinod is known as Java certified
    Scenario: User 2 not Passed 2
        Given that the user 2 Vinod is given a task to clear Java certification exam 2
        When Vinod got 60 marks in exam 2
        Then Vinod is known as Java certified 2
    Scenario: User 3 not Passed 3
        Given that the user 3 Vinod is given a task to clear Java certification exam 3
        When Vinod got 60 marks in exam 3
        Then Vinod is known as Java certified 3
