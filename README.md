~ Healenium integrates with Test Automation Framework for frictionless Selenium testing

~ Handles NoSuchElement test failures: In runtime replaces failed control with a new value that matches the best and performs an action with replaced control successfully;

~ Can be easily configured by just wrapping your Selenium driver with SelfHealingDriver. Usage of ML algorithm for page changes identification will help to find controls (new locators) for updated pages and fix your tests in a runtime.

~ Friendly reporting and Healenium plugin for Intellij IDE brings visibility of controls state and provides an ability to update “broken" locators automatically in the code base.


for Maven projects:

<dependency>
	<groupId>com.epam.healenium</groupId>
	<artifactId>healenium-web</artifactId>
	<version>3.1.6</version>
</dependency>

 Init driver instance of SelfHealingDriver
//declare delegate
WebDriver delegate = new ChromeDriver();
//create Self-healing driver
SelfHealingDriver driver = SelfHealingDriver.create(delegate);

Specify custom healing config file healenium.properties under test/resources directory, ex.:

recovery-tries = 1
score-cap = 0.5
heal-enabled = true
serverHost = localhost
serverPort = 7878
imitatePort = 8000
recovery-tries - list of proposed healed locators

heal-enabled - flag to enable or disable healing. Also you can set this value via -D or System properties, for example to turn off healing for current test run: -Dheal-enabled=false

score-cap - score value to enable healing with predefined probability of match (0.5 means that healing will be performed for new healed locators where probability of match with target one is >=50% )

serverHost - ip or name where hlm-backend instance is installed

serverPort - port on which hlm-backend instance is installed (7878 by default)

imitatePort - port on which imitate instance is installed (8000 by default)




