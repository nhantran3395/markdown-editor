import PreviewIcon from "@/assets/icons/icon-show-preview.svg";

export function SubHeader() {
  return (
    <header className="w-full bg-gray-100 flex relative">
      <div className={"flex-1 py-3 pl-4"}>
        <h2 className={"text-gray-400 text-heading-s"}>MARKDOWN</h2>
      </div>
      <div className={"w-[1px] h-[full] border-r-gray-200 border-r-[1px]"} />
      <div className={"flex-1 py-3 pl-4 max-sm:hidden"}>
        <h2 className={"text-gray-400 text-heading-s"}>PREVIEW</h2>
      </div>
      <PreviewIcon className={"absolute right-4 top-4"}></PreviewIcon>
    </header>
  );
}