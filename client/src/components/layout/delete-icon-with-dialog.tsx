import Image from "next/image";

import {
  Dialog,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";

export function DeleteIconWithDialog() {
  return (
    <Dialog>
      <DialogTrigger>
        <Image src={"icon-delete.svg"} alt={"Delete"} width={18} height={20} />
      </DialogTrigger>
      <DialogContent className="w-[343px]">
        <DialogHeader className={"text-left"}>
          <h1 className={"text-preview-heading-2xl"}>Delete this document?</h1>
          <p className={"text-gray-500 text-preview-body"}>
            Are you sure you want to delete the ‘welcome.md’ document and its
            contents? This action cannot be reversed.
          </p>
        </DialogHeader>
        <DialogFooter>
          <Button className={"w-full"}>Confirm & Delete</Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}