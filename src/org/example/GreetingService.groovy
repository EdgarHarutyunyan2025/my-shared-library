package org.example

import groovy.json.JsonSlurper

class GreetingService {
    String configFilePath = 'resources/config.json'

    def loadConfig() {
        def configFile = new File(configFilePath)
        if (configFile.exists()) {
            def jsonSlurper = new JsonSlurper()
            def config = jsonSlurper.parse(configFile)
            return config
        } else {
            throw new FileNotFoundException("Config file not found at ${configFilePath}")
        }
    }

    def generateGreeting(String name) {
        def config = loadConfig()
        def greetingTemplate = config.greeting
        return greetingTemplate.replace("{name}", name)
    }
}

