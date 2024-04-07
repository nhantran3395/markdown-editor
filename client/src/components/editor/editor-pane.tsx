"use client";

import { SubHeader } from "@/components/editor/sub-header";
import { MarkdownPane } from "@/components/editor/markdown-pane";
import { clsx } from "clsx";
import { PreviewPane } from "@/components/editor/preview-pane";
import { ChangeEvent, useState } from "react";

type EditorPaneProps = {
  defaultText: string;
};

export const EditorPane = ({ defaultText }: EditorPaneProps) => {
  const [fullPreview, setFullPreview] = useState(false);
  const [body, setBody] = useState(defaultText);

  function onToggleFullPreview() {
    setFullPreview((prev) => !prev);
  }

  function onChangeMarkdownContent(event: ChangeEvent<HTMLTextAreaElement>) {
    setBody(event.target.value);
  }

  return (
    <>
      <SubHeader
        fullPreview={fullPreview}
        onToggleFullPreview={onToggleFullPreview}
      />
      <section className={"flex flex-1 overflow-auto"}>
        {fullPreview ? null : (
          <div
            className={
              "flex-1 py-4 pl-4 border-r-gray-200 border-r-[1px] overflow-auto"
            }
          >
            <MarkdownPane body={body} onBodyChange={onChangeMarkdownContent} />
          </div>
        )}
        <div
          className={clsx(
            "flex-1 py-4 pl-4 overflow-auto",
            !fullPreview && "max-sm:hidden",
          )}
        >
          <PreviewPane body={body} />
        </div>
      </section>
    </>
  );
};