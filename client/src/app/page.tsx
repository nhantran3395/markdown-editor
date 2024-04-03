import { SubHeader } from "@/components/editor/sub-header";
import { MarkdownPane } from "@/components/editor/markdown-pane";
import { PreviewPane } from "@/components/editor/preview-pane";

export default function Home() {
  return (
    <>
      <SubHeader />
      <section className={"flex flex-1 overflow-auto"}>
        <div
          className={
            "flex-1 py-4 pl-4 border-r-gray-200 border-r-[1px] overflow-auto"
          }
        >
          <MarkdownPane />
        </div>
        <div className={"flex-1 py-4 pl-4 max-sm:hidden overflow-auto"}>
          <PreviewPane />
        </div>
      </section>
    </>
  );
}