import Image from "next/image";

import { Label } from "@/components/ui/label";
import { Button } from "@/components/ui/button";
import { MenuSidebar } from "./menu-sidebar";

export function Header() {
  return (
    <nav className={"bg-gray-700 flex items-center justify-between"}>
      <div className="flex gap-x-6 items-center">
        <MenuSidebar />
        <div className={"max-md:hidden w-[130px] h-[12px] relative"}>
          <Image src={"logo.svg"} alt={"Markdown"} fill={true} />
        </div>
        <div
          className={"max-md:hidden border-l-[1px] h-[40px] border-l-gray-500"}
        />
        <div className="flex gap-x-4 items-center">
          <Image
            src={"icon-document.svg"}
            alt={"Document"}
            width={14}
            height={16}
          />
          <div className={"flex sm:flex-col"}>
            <Label className={"text-body text-gray-400 max-sm:hidden"}>
              Document Name
            </Label>
            <Label className={"text-white"}>Welcome.md</Label>
          </div>
        </div>
      </div>
      <div className={"flex gap-x-6 m-2 sm:m-4 items-center"}>
        <Button variant={"ghost"} size={"icon"}>
          <Image
            src={"icon-delete.svg"}
            alt={"Delete"}
            width={18}
            height={20}
          />
        </Button>
        <Button className={"flex gap-x-2"}>
          <Image src={"icon-save.svg"} alt={"Save"} width={16} height={16} />
          <span className={"max-sm:hidden"}>Save Changes</span>
        </Button>
      </div>
    </nav>
  );
}