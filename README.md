## UI Testing 

## GitHub Repository

[GitHub Repository Link](https://github.com/rsahoo968/Assignment6_Code)

This repository includes:
- Manual UI Test: Written in Java using Playwright.
- AI-Assisted UI Test: Generated using Playwright MCP and refined for accuracy.
- GitHub Actions Workflow: Automatically builds the project and executes all Playwright tests to ensure they compile and pass.

---

## Automated Testing

The provided GitHub Action workflow (`.github/workflows/playwright.yml`) automatically:
1. Checks out the repository.
2. Sets up Java 24 (matching the project’s `pom.xml`).
3. Installs Playwright and browser dependencies.
4. Builds the Maven project.
5. Runs all JUnit and Playwright tests.



---

## Reflection

Manual UI testing in Java using Playwright took a lot of time and patience. I had to write every step myself, like finding the search bar, clicking buttons, and checking if pages loaded correctly. Each line of code had to be exact, or the test would fail. Sometimes it didn’t work right away, and I had to figure out why. Maybe I picked the wrong element or didn’t wait long enough for something to show up. It was slow, but doing it by hand helped me understand how the website worked and how Playwright followed each command. It gave me a clear idea of what was happening behind the scenes and made me think carefully about each part of the test.

AI-assisted testing with Playwright MCP made things a lot faster. Instead of typing all the code myself, I could just tell the AI what I wanted it to do in plain language. I could say something simple like “Search for earbuds, add them to the cart, and check that the cart shows one item.” The AI wrote most of the code for me in Java. It felt easier because I didn’t have to worry about the exact syntax or commands. It was nice to see the code appear in seconds, and it made creating tests less stressful.

Even though it was faster, the AI’s code wasn’t always right. Sometimes it chose the wrong button or forgot to wait for a page to load. I still had to check the code and fix little mistakes. It showed me that AI can be really helpful, but it still needs a person to make sure everything works properly. I had to test the AI’s code a few times and make small changes before it passed all the steps.

Manual testing gave me more control and helped me learn more, while AI testing was quicker and easier but needed corrections. Both have their good sides. Manual testing is better for learning and understanding, and AI testing is great for saving time. I think the best way is to use both together — let the AI write the test first, then go through it myself to make sure everything is right and working well.


