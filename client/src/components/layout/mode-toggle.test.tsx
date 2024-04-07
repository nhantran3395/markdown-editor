import { describe, expect, test } from "vitest";
import { screen, render } from "@testing-library/react";
import { userEvent } from "@testing-library/user-event";

import { ModeToggle } from "./mode-toggle";

describe("ModeToggle", () => {
  test("sees the switch", () => {
    render(<ModeToggle initialMode={"light"} />);
    expect(screen.getByTestId("mode-switch")).toBeInTheDocument();
  });

  test("when in light mode, presses switch toggles dark mode", async () => {
    const container = render(<ModeToggle initialMode={"light"} />);
    const user = userEvent.setup();
    await user.click(screen.getByTestId("mode-switch"));
    expect(container.baseElement).toHaveClass("dark");
  });

  test("when in dark mode, presses switch toggles light mode", async () => {
    const container = render(<ModeToggle initialMode={"light"} />);
    const user = userEvent.setup();
    await user.click(screen.getByTestId("mode-switch"));
    expect(container.baseElement).toHaveClass("dark");
  });
});