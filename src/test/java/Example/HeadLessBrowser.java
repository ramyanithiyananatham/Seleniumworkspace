package Example;

public class HeadLessBrowser {
	private void getQuestions() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://stackoverflow.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        List<WebElement> questions = driver.findElements(By.className("question-hyperlink"));
        questions.forEach((question) -> {
            System.out.println(question.getText());
        });
       driver.close();
    }
}
