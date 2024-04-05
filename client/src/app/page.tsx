"use client";
import { useState } from "react";
import { clsx } from "clsx";

import { SubHeader } from "@/components/editor/sub-header";
import { MarkdownPane } from "@/components/editor/markdown-pane";
import { PreviewPane } from "@/components/editor/preview-pane";

export default function Home() {
  const [fullPreview, setFullPreview] = useState(false);

  function onToggleFullPreview() {
    setFullPreview((prev) => !prev);
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
            <MarkdownPane />
          </div>
        )}
        <div
          className={clsx(
            "flex-1 py-4 pl-4 overflow-auto",
            !fullPreview && "max-sm:hidden",
          )}
        >
          <PreviewPane />
        </div>
      </section>
    </>
  );
}