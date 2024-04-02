import Image from "next/image";

import { Button } from "@/components/ui/button";
import { Label } from "@/components/ui/label";
import { Drawer, DrawerContent, DrawerTrigger } from "@/components/ui/drawer";
import { ModeToggle } from "@/components/layout/mode-toggle";

export function MenuSidebar() {
  return (
    <Drawer>
      <DrawerTrigger
        className={
          "bg-gray-600 hover:bg-gray-600 rounded-none h-14 w-14 sm:h-[72px] sm:w-[72px] justify-center inline-flex items-center"
        }
      >
        <div className={"h-[14px] w-[23px] sm:h-[18px] sm:w-[30px] relative"}>
          <Image src={"icon-menu.svg"} alt={"Menu"} fill={true} />
        </div>
      </DrawerTrigger>
      <DrawerContent className="w-[250px] px-6 py-7">
        <div className={"w-[130px] h-[12px] relative"}>
          <Image src={"logo.svg"} alt={"Markdown"} fill={true} />
        </div>
        <div className={"mt-7"}>
          <h1 className={"text-heading-s"}>MY DOCUMENTS</h1>
          <Button className={"mt-7 mb-6"}>+ New Document</Button>
          <ul className={"flex flex-col gap-y-6"}>
            <li className={"flex flex-col gap-y-[3px]"}>
              <Label>01 April 2022</Label>
              <Label className={"text-heading-m text-white"}>
                untitled-document.md
              </Label>
            </li>
            <li className={"flex flex-col gap-y-[3px]"}>
              <Label>01 April 2022</Label>
              <Label className={"text-heading-m text-white"}>welcome.md</Label>
            </li>
          </ul>
        </div>
        <div className={"mt-auto"}>
          <ModeToggle />
        </div>
      </DrawerContent>
    </Drawer>
  );
}