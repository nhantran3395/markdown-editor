import { Button } from "@/components/ui/button";
import { Label } from "@/components/ui/label";
import {
  Drawer,
  DrawerClose,
  DrawerContent,
  DrawerTrigger,
} from "@/components/ui/drawer";
import { ModeToggle } from "@/components/layout/mode-toggle";
import { type Mode } from "@/types/mode";

import MenuIcon from "@/assets/icons/icon-menu.svg";
import Logo from "@/assets/icons/logo.svg";
import CloseIcon from "@/assets/icons/icon-close.svg";

type MenuSidebarProps = {
  initialMode: Mode;
};

export function MenuSidebar({ initialMode }: Readonly<MenuSidebarProps>) {
  return (
    <Drawer>
      <DrawerTrigger
        className={
          "bg-gray-600 hover:bg-gray-600 rounded-none h-14 w-14 sm:h-[72px] sm:w-[72px] justify-center inline-flex items-center"
        }
      >
        <MenuIcon />
      </DrawerTrigger>
      <DrawerContent className="w-[250px] px-6 py-7">
        <Logo />
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
          <ModeToggle initialMode={initialMode} />
        </div>
        <DrawerClose>
          <div
            className={
              "bg-gray-600 hover:bg-gray-600 rounded-none h-14 w-14 sm:h-[72px] sm:w-[72px] justify-center inline-flex items-center absolute top-0 left-[100%]"
            }
          >
            <CloseIcon />
          </div>
        </DrawerClose>
      </DrawerContent>
    </Drawer>
  );
}