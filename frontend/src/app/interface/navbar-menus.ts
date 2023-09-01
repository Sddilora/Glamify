// Add navbars with submenus here
export const NAVBAR_MENUS: NavbarMenu[] = [
  {
    name: 'HOME',
    submenus: [
      {
        name: 'KITCHEN',
      },
      {
        name: 'FURNITURE',
      },
      {
        name: 'DECOR',
      },
      {
        name: 'APPLIANCES',
      },
      {
        name: 'PET',
      },
      {
        name: 'BATHROOM',
      },
      {
        name: 'GARDEN',
      },
      {
        name: 'TOOLS',
      },
      {
        name: 'APPLIANCES',
      },
      {
        name: 'OFFICE',
      },
      {
        name: 'GROCERY',
      },
      {
        name: 'HEALTH',
      },
      {
        name: 'BEAUTY',
      },
    ]
  },
  {
    name: 'ELECTRONICS',
    submenus: [
      {
        name: 'MOBILE',
      },
      {
        name: 'COMPUTER',
      },
      {
        name: 'CAMERA',
      },
      {
        name: 'TV',
      },
      {
        name: 'APPLIANCES',
      },
    ]
  },
  {
    name: 'FASHION',
    submenus: [
      {
        name: 'WOMEN',
      },
      {
        name: 'MAN',
      },
      {
        name: 'KIDS',
      },
      {
        name: 'BABY'
      },
      {
        name: 'BAGS',
      },
      {
        name: 'FOOTWEAR',
      },
      {
        name: 'WATCHES',
      },
      {
        name: 'JEWELLERY',
      },
      {
        name: 'ACCESSORIES',
      },
    ]
  },
  {
    name: 'SPORTS',
    submenus: [
      {
        name: 'INDOOR',
      },
      {
        name: 'OUTDOOR',
      },
      {
        name: 'FITNESS',
      },
      {
        name: 'SPORTSWEAR',
      }
    ]
  },
];

export class NavbarMenu {
  name: string;
  submenus? : NavbarMenu[];


  constructor(name: string, submenus: NavbarMenu[]) {
    this.name = name;
    this.submenus = submenus;
  }
}
