import { SubHeader } from "@/components/editor/sub-header";
import { MarkdownPane } from "@/components/editor/markdown-pane";
import { PreviewPane } from "@/components/editor/preview-pane";

export default function Home() {
  return (
    <>
      <SubHeader />
      <section className={"flex flex-1"}>
        <div className={"flex-1 py-4 pl-4"}>
          <MarkdownPane />
        </div>
        <div className={"w-[1px] border-r-gray-200 border-r-[1px]"} />
        <div className={"flex-1 py-4 pl-4 max-sm:hidden"}>
          <PreviewPane />
        </div>
      </section>
    </>
  );
}