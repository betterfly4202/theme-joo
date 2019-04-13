export interface ITheme {
  themeId: number;
  title: string;
  subTitle: string;
  tags: ITag[];
  data: number[];
  imageUrl: string;
}

export class Theme implements ITheme {
  themeId: number;
  title: string;
  subTitle: string;
  tags: ITag[];
  data: number[];
  imageUrl: string;

  constructor(themeId: number, title: string, subTitle: string, tags: ITag[], data: number[], imageUrl: string) {
    this.themeId = themeId;
    this.title = title;
    this.subTitle = subTitle;
    this.tags = tags;
    this.data = data;
    this.imageUrl = imageUrl;
  }
}

export interface ITag {
  tagId: number;
  title: string;
}

export class Tag implements ITag {
  tagId: number;
  title: string;

  constructor(tagId: number, title: string) {
    this.tagId = tagId;
    this.title = title;
  }
}
