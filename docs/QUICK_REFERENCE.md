# Quick Reference: Setting Main as Default Branch

## Current Status ✅

The repository is already configured to use `main` as the primary development branch:
- ✅ `main` branch exists and contains the latest code
- ✅ No `master` branch exists in the repository
- ✅ Documentation has been updated to reference `main`

## What Was Done ✅

1. **Created comprehensive documentation** (`docs/BRANCH_CONFIGURATION.md`)
   - Step-by-step guide for setting default branch on GitHub
   - Instructions for removing master branch if needed
   - Local repository update procedures
   - Best practices and recommendations

2. **Updated README.md**
   - Added proper git clone instructions
   - Added note about `main` being the default branch
   - Linked to branch configuration guide

## What You Need to Do ⚠️

To complete the configuration, you (as repository owner) need to:

### 1. Set Default Branch on GitHub

**Quick Steps:**
1. Go to: https://github.com/souravk29/FoodRecipe_app/settings
2. Scroll to "Default branch" section
3. Click the switch/pencil icon
4. Select `main` from dropdown
5. Click "Update" or "I understand, update the default branch"

**Why this is important:**
- New pull requests will target `main` by default
- New clones will check out `main` by default
- GitHub UI will show `main` as the primary branch

### 2. Update Branch Protection Rules (Optional)

If you have branch protection rules on `master`, move them to `main`:
1. Go to: https://github.com/souravk29/FoodRecipe_app/settings/branches
2. Remove protection from `master` (if it exists)
3. Add protection rules to `main`

### 3. Verify Configuration

After changing the default branch:
```bash
# Check what GitHub says is the default
git ls-remote --symref origin HEAD

# It should show: ref: refs/heads/main	HEAD
```

## For Team Members

If you have a local clone of the repository:
```bash
# Fetch latest changes
git fetch origin

# Switch to main
git checkout main
git pull origin main

# Update remote HEAD reference
git remote set-head origin -a

# If you have a local master branch, delete it
git branch -d master
```

## Reference

For detailed instructions, see:
- [Branch Configuration Guide](BRANCH_CONFIGURATION.md)
- [GitHub Documentation: Changing Default Branch](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-branches-in-your-repository/changing-the-default-branch)

---

**Note:** Changing the default branch on GitHub requires repository admin permissions and must be done through the GitHub web interface or API. It cannot be done via git commands alone.
