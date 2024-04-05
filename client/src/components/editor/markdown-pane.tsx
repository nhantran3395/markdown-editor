import { ChangeEvent } from "react";

type MarkdownPaneProps = {
  body: string;
  onBodyChange: (event: ChangeEvent<HTMLTextAreaElement>) => void;
};

export function MarkdownPane({
  body,
  onBodyChange,
}: Readonly<MarkdownPaneProps>) {
  return (
    <article className={"text-markup-body w-full h-full"}>
      <textarea
        value={body}
        onChange={onBodyChange}
        className={
          "w-full h-full bg-background text-foreground resize-none outline-none"
        }
      />
    </article>
  );
}