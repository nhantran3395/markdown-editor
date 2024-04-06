import { test, expect } from "@playwright/test";

test.describe("landing", () => {
  test("sees 'Markdown editor' as page title", async ({ page }) => {
    await page.goto("/");

    // Expect a title "to contain" a substring.
    await expect(page).toHaveTitle(/Markdown editor/i);
  });

  test("sees 'Welcome.md' by default", async ({ page }) => {
    await page.goto("/");

    await expect(page.getByTestId("document-name")).toBeVisible();
  });
});

test.describe("sidebar menu", () => {
  test.beforeEach(async ({ page }) => {
    await page.goto("/");
  });

  test("clicks on menu icon will see sidebar", async ({ page }) => {
    await page.getByTestId("menu-sidebar-trigger").click();

    await expect(
      page.getByRole("heading", { name: /my documents/i }),
    ).toBeVisible();
    await expect(
      page.getByRole("button", { name: /new document/i }),
    ).toBeVisible();
  });

  test("clicks on close icon will close sidebar", async ({ page }) => {
    await page.getByTestId("menu-sidebar-trigger").click();

    await page.getByTestId("menu-sidebar-close").click();

    await expect(
      page.getByRole("heading", { name: /my documents/i }),
    ).not.toBeVisible();
    await expect(
      page.getByRole("button", { name: /new document/i }),
    ).not.toBeVisible();
  });

  test("clicks outside of the drawer icon will close sidebar", async ({
    page,
  }) => {
    await page.getByTestId("menu-sidebar-trigger").click();

    await page.locator(".fixed").first().click();

    await expect(
      page.getByRole("heading", { name: /my documents/i }),
    ).not.toBeVisible();
    await expect(
      page.getByRole("button", { name: /new document/i }),
    ).not.toBeVisible();
  });
});