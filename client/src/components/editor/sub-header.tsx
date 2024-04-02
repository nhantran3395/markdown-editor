import Image from "next/image";

export function SubHeader() {
  return (
    <div className="w-full bg-gray-100 flex relative">
      <div className={"flex-1 py-3 pl-4"}>
        <h2 className={"text-gray-400 text-heading-s"}>MARKDOWN</h2>
      </div>
      <div className={"w-[1px] h-[full] border-r-gray-200 border-r-[1px]"} />
      <div className={"flex-1 py-3 pl-4 max-sm:hidden"}>
        <h2 className={"text-gray-400 text-heading-s"}>PREVIEW</h2>
      </div>
      <div className={"absolute right-4 top-4"}>
        <Image
          src={"icon-show-preview.svg"}
          alt={"Show preview"}
          width={16}
          height={12}
        />
      </div>
    </div>
  );
}