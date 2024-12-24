// vars/greetUser.groovy

def call(String name) {
    try {
        def greetingService = new org.example.GreetingService()

        def greetingMessage = greetingService.generateGreeting(name)

        echo greetingMessage
    } catch (Exception e) {
        error "An error occurred while generating greeting: ${e.message}"
    }
}

