import { Dialog, DialogContent, DialogTrigger } from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";

import DeleteIcon from "@/assets/icons/icon-delete.svg";

export function DeleteIconWithDialog() {
  return (
    <Dialog>
      <DialogTrigger>
        <DeleteIcon className={"fill-gray-400 hover:fill-orange-600"} />
      </DialogTrigger>
      <DialogContent className="w-[343px]">
        <div className={"text-left"}>
          <h1 className={"text-preview-heading-2xl"}>Delete this document?</h1>
          <p className={"text-gray-500 text-preview-body"}>
            Are you sure you want to delete the ‘welcome.md’ document and its
            contents? This action cannot be reversed.
          </p>
        </div>
        <Button className={"w-full"}>Confirm & Delete</Button>
      </DialogContent>
    </Dialog>
  );
}