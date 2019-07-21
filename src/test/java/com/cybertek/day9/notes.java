package com.cybertek.day9;

public class notes {

    /**
     *
     *
     *
     * Todays is 7/9/2019
     * Agenda:
     *  Xpath only:
     *     Absolute vs relative xpath
     *     contains
     *     starts-with
     *     text() or .
     *     *
     *     indexes
     *     find parent/ancestor then element
     *     siblings
     *     Why to use xpath over other locators?
     * #################################
     *     Which locators to choose?
     *     1. ID always first
     *     2. then probably CSS Selector
     *     3. Then everything else
     *     Xpath can handle any element
     *     What is dynamic element. Element that has different position on every load.
     *     If id is dynamic (that means id="value", after reloading of page id="new_value") that means we cannot rely on this id.
     *     How to check or how to figure out that id is dynamic?
     *     Try to refresh page and see if id changes.
     *     It's not only about being dynamic. Let's say developers updated code and they manually changed some attributes.
     * Story:
     * During development of new functionality, I was developing my automation scripts. And after design was changed, I had to update locators and even logic of my script too.
     * ##############################
     * Absolute vs Relative xpath.
     *  Absolute xpath starts from root element. In HTML root element is <html>. You cannot jump into middle of HTML document.
     *  Example:
     *   String fullNameLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']";
     *     String emailLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']";
     *     String signUpButton = "html/body/div/div[2]/div/div/form/button";
     *  org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
     *  Relative xpath:
     *     //tagname[@attribue='value']
     *     tag - has purple color
     *     attribute - light brown
     *     blue - it's a value of attribute
     *     black - text
     *     <div class="large-6 small-12 columns"> <-opening tag
     *         <label for="password">Email</label>
     *         <input type="email" name="email">
     *     </div> <- closing tag
     *     label and input are children of div
     *     div is a parent of label and input  - label and input are inside div
     *     label and input are siblings - because they have same parent
     *     Browser treats  HTML page like a tree of nodes.
     *  String button3Locator = "//button[starts-with(@id,'button_')]";
     *  starts-with - to specify beginning of attribute or text.
     *  REMEMBER: There is no perfect locator. You have to write it and test it. If you need locator to print on specific element, but it point on multiple elements - change it (choose different attributes, maybe use text or partial text, use parent-child relationship).
     * One more thing. Also, we can use starts-with to allocate multiple elements (List<WebElement>) based on partially common attribute value.
     * Text and attribute value is case sensitive.
     * //button[contains(text(),'Button 4')] - we can find button based on partial text.
     * >text<
     * //button[5] - with [index] we can specify which child do we need.
     * * - means wildcard, it can replace any tag
     * //button[text()='Button 1']
     * //button[.='Button 1'] - . means text.
     * In this case we are looking for element by exact text. If there are some spaces or extra chars, this locator will not work. Text must be exactly same.
     * //*[contains(@name,'button2')] - find any element, that contains name 'button2'
     * org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//*[@id='disappearing_button']"}
     * If element is not in the DOM (let's say not in the html), and you are trying to find that element, you will get exception. After we clicked on the button, that button was deleted. isDisplayed() will not work, because it will fail on the finding stage.
     * If you need to check if element is gone, not on the page:
     * Assert.assertTrue(driver.findElements(By.xpath(button6locator)).size() == 0);
     * findElements(By.xpath(button6locator)).size() == 0 <- means 0 elements found based on this locator. No exception will occur.
     * The thing is findElements() returns List<WebElements>. If this collection is empty, or size is equals to 0, then no elements found.
     * (//div[@id='custom_entity-update']//a)[1] - means find element with id custom_entity-update and go to child a. Then select only first element.
     * //div[@id='custom_entity-update']//a[.='General'] - find div with id custom_entity-update, and the find child with link text General.
     */
}
