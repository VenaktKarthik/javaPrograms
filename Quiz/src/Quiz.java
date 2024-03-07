import java.util.Scanner;
class Quiz {
    private Question[] questions;
    private int score;
    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
    }
    public void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            displayQuestion(question);
            System.out.print("Enter your choice (1/2/3/4): ");
            long startTime = System.currentTimeMillis();
            String userAnswer = scanner.nextLine().trim();
            long endTime = System.currentTimeMillis();
            if ((endTime - startTime) > 10000) {
                System.out.println("Time's up!");
                continue;
            }
            if (userAnswer.equals(question.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            System.out.println();
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + "/" + questions.length);
        System.out.println("Correct answers:");
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.println("Correct answer: " + question.getOptions()[Integer.parseInt(question.getAnswer()) - 1]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, "1"),
                new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "Mark Twain", "F. Scott Fitzgerald", "Ernest Hemingway"}, "1"),
                new Question("What is the chemical symbol for water?", new String[]{"H2O", "CO2", "NaCl", "C6H12O6"}, "1")
        };

        Quiz quiz = new Quiz(questions);
        quiz.runQuiz();
    }
}

class Question {
    private String question;
    private String[] options;
    private String answer;

    public Question(String question, String[] options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
