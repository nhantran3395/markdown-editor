import Markdown from "react-markdown";

type PreviewPaneProps = {
  body: string;
};

export function PreviewPane({ body }: Readonly<PreviewPaneProps>) {
  return (
    <article className={"text-preview-body"}>
      <Markdown>{body}</Markdown>
    </article>
  );
}