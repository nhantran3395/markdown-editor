import { describe, test, expect } from "vitest";
import { screen, render } from "@testing-library/react";
import userEvent from "@testing-library/user-event";

import { EditorPane } from "./editor-pane";

describe("EditorPane", () => {
  test("sees both markdown pane and preview pane initially", () => {
    render(<EditorPane defaultText={"Hi"} />);
    expect(
      screen.getByRole("heading", { name: /markdown/i }),
    ).toBeInTheDocument();
    expect(
      screen.getByRole("heading", { name: /preview/i }),
    ).toBeInTheDocument();
    expect(screen.getByTestId("pane-toggle")).toBeInTheDocument();
  });

  test("clicks icon will show preview pane in full view", async () => {
    render(<EditorPane defaultText={"Hi"} />);
    const user = userEvent.setup();
    await user.click(screen.getByTestId("pane-toggle"));
    expect(
      screen.queryByRole("heading", { name: /markdown/i }),
    ).not.toBeInTheDocument();
    expect(
      screen.getByRole("heading", { name: /preview/i }),
    ).toBeInTheDocument();
  });

  test("when in full preview, clicks icon will go back to showing both markdown pane and preview pane", async () => {
    render(<EditorPane defaultText={"Hi"} />);
    const user = userEvent.setup();
    await user.click(screen.getByTestId("pane-toggle"));
    await user.click(screen.getByTestId("pane-toggle"));

    expect(
      screen.getByRole("heading", { name: /markdown/i }),
    ).toBeInTheDocument();
    expect(
      screen.getByRole("heading", { name: /preview/i }),
    ).toBeInTheDocument();
  });
});