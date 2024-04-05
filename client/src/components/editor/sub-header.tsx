import { clsx } from "clsx";

import ShowPreviewIcon from "@/assets/icons/icon-show-preview.svg";
import HidePreviewIcon from "@/assets/icons/icon-hide-preview.svg";

type SubHeaderProps = {
  fullPreview: boolean;
  onToggleFullPreview: () => void;
};

export function SubHeader({
  fullPreview,
  onToggleFullPreview,
}: Readonly<SubHeaderProps>) {
  return (
    <header className="w-full bg-gray-100 flex relative">
      {fullPreview ? null : (
        <>
          <div
            className={clsx("flex-1 py-3 pl-4", fullPreview && "max-sm:hidden")}
          >
            <h2 className={"text-gray-400 text-heading-s"}>MARKDOWN</h2>
          </div>
          <div
            className={clsx(
              "w-[1px] h-[full] border-r-gray-200 border-r-[1px]",
              fullPreview && "max-sm:hidden",
            )}
          />
        </>
      )}
      <div
        className={clsx("flex-1 py-3 pl-4", !fullPreview && "max-sm:hidden")}
      >
        <h2 className={"text-gray-400 text-heading-s"}>PREVIEW</h2>
      </div>
      {fullPreview ? (
        <HidePreviewIcon
          className={"absolute right-4 top-4"}
          onClick={onToggleFullPreview}
        />
      ) : (
        <ShowPreviewIcon
          className={"absolute right-4 top-4"}
          onClick={onToggleFullPreview}
        />
      )}
    </header>
  );
}