import { Button } from "@/components/ui/button";
import { Switch } from "@/components/ui/switch";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import {
  DrawerTrigger,
  DrawerContent,
  DrawerClose,
  Drawer,
} from "@/components/ui/drawer";
import {
  Dialog,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTrigger,
} from "@/components/ui/dialog";

export default function StyleGuide() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <p className={"text-body"}>Hi there welcome to markdown editor</p>
      <h3 className={"text-heading-s"}>Hi there welcome to markdown editor</h3>
      <h2 className={"text-heading-m"}>Hi there welcome to markdown editor</h2>
      <h1 className={"text-preview-heading-4xl"}>
        Hi there welcome to markdown editor
      </h1>
      <h2 className={"text-preview-heading-3xl"}>
        Hi there welcome to markdown editor
      </h2>
      <h3 className={"text-preview-heading-2xl"}>
        Hi there welcome to markdown editor
      </h3>
      <h4 className={"text-preview-heading-xl"}>
        Hi there welcome to markdown editor
      </h4>
      <h5 className={"text-preview-heading-lg"}>
        Hi there welcome to markdown editor
      </h5>
      <h6 className={"text-preview-heading-sm"}>
        Hi there welcome to markdown editor
      </h6>
      <p className={"text-preview-body"}>Hi there welcome to markdown editor</p>
      <p className={"text-preview-body font-bold"}>
        Hi there welcome to markdown editor
      </p>
      <p className={"text-markup-body"}>Hi there welcome to markdown editor</p>
      <Button>Save Changes</Button>
      <Button variant={"ghost"} size={"icon"}>
        +
      </Button>
      <Switch />
      <div>
        <Label htmlFor={"documentName"}>Document Name</Label>
        <Input id={"documentName"} type={"text"} />
      </div>
      <div>
        <Drawer>
          <DrawerTrigger>Open Drawer</DrawerTrigger>
          <DrawerContent>
            <h1 className={"text-heading-m"}>Are you absolutely sure?</h1>
            <p className={"text-body"}>This action cannot be undone.</p>
            <DrawerClose>
              <Button>Cancel</Button>
            </DrawerClose>
          </DrawerContent>
        </Drawer>
      </div>
      <div>
        <Dialog>
          <DialogTrigger>Open Dialog</DialogTrigger>
          <DialogContent>
            <DialogHeader>
              <h1 className={"text-preview-heading-2xl"}>
                Are you absolutely sure?
              </h1>
              <p className={"text-gray-500 text-preview-body"}>
                This action cannot be undone. This will permanently delete your
                account and remove your data from our servers.
              </p>
            </DialogHeader>
            <DialogFooter>
              <Button className={"w-full"}>Confirm & Delete</Button>
            </DialogFooter>
          </DialogContent>
        </Dialog>
      </div>
    </main>
  );
}